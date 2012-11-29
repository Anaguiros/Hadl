package model.serveur.securityManager;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseResultMessage;

public class PortSecurityResults extends PortComposantCompositeRequis {

	public PortSecurityResults(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(DatabaseResultMessage databaseResultMessage) {
		this.setChanged();
		this.notifyObservers(databaseResultMessage);
	}

}
