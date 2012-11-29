package model.serveur.database;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseQueryMessage;

public class PortRequeteSQL extends PortComposantCompositeRequis {

	public PortRequeteSQL(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(DatabaseQueryMessage databaseQueryMessage) {
		this.setChanged();
		this.notifyObservers(databaseQueryMessage);
	}

}
