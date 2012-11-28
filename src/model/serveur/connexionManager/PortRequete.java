package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseQueryMessage;

public class PortRequete extends PortComposantCompositeFourni {

	public PortRequete(String name, ServiceCompositeFourni service) {
		super(name, service);
	}

	public void send(DatabaseQueryMessage databaseQueryMessage) {
		this.setChanged();
		this.notifyObservers(databaseQueryMessage);
	}
}
