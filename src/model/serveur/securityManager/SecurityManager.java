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
			if (object instanceof AuthMessage) {
				DatabaseQueryMessage databaseQueryMessage = this.process((AuthMessage) object);
				this.serviceSecurityComputing.send(databaseQueryMessage);
			}
		}
		else if (o instanceof ServiceSecurityResults) {
			if (object instanceof DatabaseResultMessage) {
				ResponseMessage responseMessage = this.process((DatabaseResultMessage) object);
				this.serviceAuthResults.send(responseMessage);
			}
		}
	}
	
	public DatabaseQueryMessage process(AuthMessage authMessage) {
		DatabaseQueryMessage databaseQueryMessage = new DatabaseQueryMessage("pouet");
		System.out.println("Resolve authentification");
		return databaseQueryMessage;
	}
	
	public ResponseMessage process(DatabaseResultMessage databaseResultMessage) {
		ResponseMessage responseMessage = null;
		if (databaseResultMessage.getResult().equals("ok")) {
			responseMessage = new AuthGrantedMessage("Access Granted !");
		}
		else {
			responseMessage = new ErrorAuthMessage("Access Refused !");
		}
		return responseMessage;
	}


}
