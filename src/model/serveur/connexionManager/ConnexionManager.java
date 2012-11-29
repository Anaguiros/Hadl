package model.serveur.connexionManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;
import model.core.AuthMessage;
import model.core.QueryMessage;
import model.core.DatabaseQueryMessage;
import model.core.DatabaseResultMessage;
import model.core.ResponseMessage;

public class ConnexionManager extends ComposantComposite implements Observer {
	
	private ServiceConnexion serviceConnexion;
	private ServiceResultat serviceResultat;
	private ServiceRequete serviceRequete;
	private ServiceResultsAuth serviceResultsAuth;
	private ServiceRequeteAuth serviceRequeteAuth;

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
			if (object instanceof QueryMessage) {
				AuthMessage authMessage = this.process((QueryMessage) object);
				this.serviceRequeteAuth.send(authMessage);
			}
			if (object instanceof DatabaseQueryMessage) {
				this.serviceRequete.getPortRequete().send((DatabaseQueryMessage) object);
			}
		}
		else if (o instanceof ServiceResultat) {
			if (object instanceof DatabaseResultMessage) {
				this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
			}
		}
		else if (o instanceof ServiceResultsAuth) {
			if (object instanceof ResponseMessage) {
				this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
			}
		}
	}
	
	public AuthMessage process(QueryMessage queryMessage) {
		AuthMessage authMessage = new AuthMessage(queryMessage.getLogin(), queryMessage.getPass());
		System.out.println("Demande d'identification");
		return authMessage;
	}

	public ServiceConnexion getServiceConnexion() {
		return this.serviceConnexion;
	}

}
