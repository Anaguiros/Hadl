package model.serveur.securityManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.ResponseMessage;

public class PortAuthResults extends PortComposantCompositeFourni {

	public PortAuthResults(String name, ServiceCompositeFourni service) {
		super(name, service);
	}
	
	public void send(ResponseMessage responseMessage) {
		this.setChanged();
		this.notifyObservers(responseMessage);
	}

}
