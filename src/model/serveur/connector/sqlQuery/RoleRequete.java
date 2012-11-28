package model.serveur.connector.sqlQuery;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.DatabaseQueryMessage;

public class RoleRequete extends RoleCompositeRequis {

	public RoleRequete(String name) {
		super(name);
	}

	public void receive(DatabaseQueryMessage databaseQueryMessage) {
		this.setChanged();
		this.notifyObservers(databaseQueryMessage);
	}

}
