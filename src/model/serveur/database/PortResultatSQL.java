package model.serveur.database;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseResultMessage;

public class PortResultatSQL extends PortComposantCompositeFourni {

	public PortResultatSQL(String name, ServiceCompositeFourni service) {
		super(name, service);
	}

	public void send(DatabaseResultMessage databaseResultMessage) {
		this.setChanged();
		this.notifyObservers(databaseResultMessage);
	}
}
