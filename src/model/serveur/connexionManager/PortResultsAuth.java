package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.ResponseMessage;

public class PortResultsAuth extends PortComposantCompositeRequis {

	public PortResultsAuth(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(ResponseMessage responseMessage) {
		this.setChanged();
		this.notifyObservers(responseMessage);
	}

}
