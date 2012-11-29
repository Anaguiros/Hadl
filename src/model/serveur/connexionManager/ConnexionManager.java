package model.serveur.connexionManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;
import model.core.AuthGrantedMessage;
import model.core.AuthMessage;
import model.core.ErrorAuthMessage;
import model.core.QueryMessage;
import model.core.DatabaseQueryMessage;
import model.core.DatabaseResultMessage;

public class ConnexionManager extends ComposantComposite implements Observer {
	
	private ServiceConnexion serviceConnexion;
	private ServiceResultat serviceResultat;
	private ServiceRequete serviceRequete;
	private ServiceResultsAuth serviceResultsAuth;
	private ServiceRequeteAuth serviceRequeteAuth;
	
	private QueryMessage queryMessage;

	public ConnexionManager(String name) {
		super(name);
		
		this.serviceResultsAuth = new ServiceResultsAuth("ServiceResultsAuth");
		this.serviceRequeteAuth = new ServiceRequeteAuth("ServiceRequeteAuth");
		this.serviceRequete = new ServiceRequete("ServiceRequete");
		this.serviceResultat = new ServiceResultat("ServiceResultat");
		this.serviceConnexion = new ServiceConnexion("ServiceConnexion");
		
		this.serviceResultsAuth.addObserver(this);
		this.serviceResultat.addObserver(this);
		this.serviceConnexion.addObserver(this);
		
		this.addInterface("ServiceResultsAuth", this.serviceResultsAuth);
		this.addInterface("ServiceRequeteAuth", this.serviceRequeteAuth);
		this.addInterface("ServiceRequete", this.serviceRequete);
		this.addInterface("ServiceResultat", this.serviceResultat);
		this.addInterface("ServiceConnexion", this.serviceConnexion);
	}
	
	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceConnexion) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "     | Reception from ServeurConfiguration : " + object);
			if (object instanceof QueryMessage) {
				AuthMessage authMessage = this.process((QueryMessage) object);
				System.out.println("<- | " + this.getClass().getSimpleName() + "     | Send to SecurityManager : " + authMessage);
				this.serviceRequeteAuth.send(authMessage);
			}
		}
		else if (o instanceof ServiceResultat) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "     | Reception from Database : " + object);
			if (object instanceof DatabaseResultMessage) {
				System.out.println(" o | " + this.getClass().getSimpleName() + "     | \tEnvoi de la reponse au serveur");
				System.out.println("<- | " + this.getClass().getSimpleName() + "     | Send to ServeurConfiguration : " + object);
				this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
			}
		}
		else if (o instanceof ServiceResultsAuth) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "     | Reception from SecurityManager : " + object);
			if (object instanceof AuthGrantedMessage) {
				DatabaseQueryMessage databaseQueryMessage = this.process((AuthGrantedMessage) object);
				System.out.println("<- | " + this.getClass().getSimpleName() + "     | Send to Database : " + databaseQueryMessage);
				this.serviceRequete.getPortRequete().send(databaseQueryMessage);
			}
			else if (object instanceof ErrorAuthMessage) {
				System.out.println(" o | " + this.getClass().getSimpleName() + "     | \tTransfert de la reponse");
				System.out.println("<- | " + this.getClass().getSimpleName() + "     | Send to ServeurConfiguration : " + object);
				this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
			}
		}
	}
	
	public AuthMessage process(QueryMessage queryMessage) {
		AuthMessage authMessage = new AuthMessage(queryMessage.getLogin(), queryMessage.getPass());
		this.queryMessage = queryMessage;
		System.out.println(" o | " + this.getClass().getSimpleName() + "     | \tDemande d'authentification");
		return authMessage;
	}
	
	public DatabaseQueryMessage process(AuthGrantedMessage queryMessage) {
		DatabaseQueryMessage databaseQueryMessage = new DatabaseQueryMessage(this.queryMessage.getQuery());
		System.out.println(" o | " + this.getClass().getSimpleName() + "     | \tEnvoi de la requete a la base de donnees !");
		return databaseQueryMessage;
	}

	public ServiceConnexion getServiceConnexion() {
		return this.serviceConnexion;
	}

}
