package model.serveur.securityManager;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.AuthMessage;

public class PortAuthComputing extends PortComposantCompositeRequis {

	public PortAuthComputing(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(AuthMessage authMessage) {
		this.setChanged();
		this.notifyObservers(authMessage);
	}

}
