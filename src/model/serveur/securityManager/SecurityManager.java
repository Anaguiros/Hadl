package model.serveur.securityManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;
import model.core.AuthGrantedMessage;
import model.core.AuthMessage;
import model.core.DatabaseQueryMessage;
import model.core.DatabaseResultMessage;
import model.core.ErrorAuthMessage;
import model.core.ResponseMessage;

public class SecurityManager extends ComposantComposite implements Observer {

	private ServiceAuthResults serviceAuthResults;
	private ServiceAuthComputing serviceAuthComputing;
	private ServiceSecurityResults serviceSecurityResults;
	private ServiceSecurityComputing serviceSecurityComputing;
	
	private AuthMessage authMessage;
	
	public SecurityManager(String name) {
		super(name);
		
		this.serviceAuthComputing = new ServiceAuthComputing("ServiceAuthComputing");
		this.serviceAuthResults = new ServiceAuthResults("ServiceAuthResults");
		this.serviceSecurityComputing = new ServiceSecurityComputing("ServiceSecurityComputing");
		this.serviceSecurityResults = new ServiceSecurityResults("ServiceSecurityResults");
		
		this.serviceAuthComputing.addObserver(this);
		this.serviceSecurityResults.addObserver(this);
		
		this.addInterface("ServiceAuthResults", this.serviceAuthResults);
		this.addInterface("ServiceAuthComputing", this.serviceAuthComputing);
		this.addInterface("ServiceSecurityResults", this.serviceSecurityResults);
		this.addInterface("ServiceSecurityComputing", this.serviceSecurityComputing);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceAuthComputing) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "      | Reception from ConnexionManager : " + object);
			if (object instanceof AuthMessage) {
				DatabaseQueryMessage databaseQueryMessage = this.process((AuthMessage) object);
				System.out.println("<- | " + this.getClass().getSimpleName() + "      | Send to Database : " + databaseQueryMessage);
				this.serviceSecurityComputing.send(databaseQueryMessage);
			}
		}
		else if (o instanceof ServiceSecurityResults) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "      | Reception from Database : " + object);
			if (object instanceof DatabaseResultMessage) {
				ResponseMessage responseMessage = this.process((DatabaseResultMessage) object);
				System.out.println("<- | " + this.getClass().getSimpleName() + "      | Send to ConnexionManager : " + responseMessage);
				this.serviceAuthResults.send(responseMessage);
			}
		}
	}
	
	public DatabaseQueryMessage process(AuthMessage authMessage) {
		DatabaseQueryMessage databaseQueryMessage = new DatabaseQueryMessage("SELECT " + authMessage.getLogin() + " FROM users");
		this.authMessage = authMessage;
		System.out.println(" o | " + this.getClass().getSimpleName() + "      | \tDemande d'authentification -> utilisateur enregistre dans la base de donnees ?");
		return databaseQueryMessage;
	}
	
	public ResponseMessage process(DatabaseResultMessage databaseResultMessage) {
		ResponseMessage responseMessage = null;
		if (databaseResultMessage.getResult().equals(this.authMessage.getPass())) {
			responseMessage = new AuthGrantedMessage("Access Granted !");
			System.out.println(" o | " + this.getClass().getSimpleName() + "      | \tAccess granted for user " + this.authMessage.getLogin());
		}
		else {
			if (databaseResultMessage.getResult().equals("invalid user")) {
				responseMessage = new ErrorAuthMessage("Access Refused ! Invalid user");
			}
			else {
				responseMessage = new ErrorAuthMessage("Access Refused ! Invalid password");
			}
			System.out.println(" o | " + this.getClass().getSimpleName() + "      | \tAccess refused for user " + this.authMessage.getLogin());
		}
		return responseMessage;
	}


}
