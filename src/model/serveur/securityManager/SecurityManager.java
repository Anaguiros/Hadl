package model.serveur.securityManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;
import model.core.AuthMessage;
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
		
		this.addInterface("ServiceAuthResults", this.serviceAuthResults);
		this.addInterface("ServiceAuthComputing", this.serviceAuthComputing);
		this.addInterface("ServiceSecurityResults", this.serviceSecurityResults);
		this.addInterface("ServiceSecurityComputing", this.serviceSecurityComputing);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceAuthComputing) {
			if (object instanceof AuthMessage) {
				ResponseMessage responseMessage = this.process((AuthMessage) object);
				this.serviceAuthResults.send(responseMessage);
			}
		}
	}
	
	public ResponseMessage process(AuthMessage authMessage) {
		ResponseMessage responseMessage = null;
		
		return responseMessage;
	}


}
