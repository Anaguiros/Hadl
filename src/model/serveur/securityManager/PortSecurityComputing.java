package model.serveur.securityManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseQueryMessage;

public class PortSecurityComputing extends PortComposantCompositeFourni {

	public PortSecurityComputing(String name, ServiceCompositeFourni service) {
		super(name, service);
	}
	
	public void send(DatabaseQueryMessage databaseQueryMessage) {
		this.setChanged();
		this.notifyObservers(databaseQueryMessage);
	}

}
