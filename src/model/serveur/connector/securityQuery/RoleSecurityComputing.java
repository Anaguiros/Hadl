package model.serveur.connector.securityQuery;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.DatabaseQueryMessage;

public class RoleSecurityComputing extends RoleCompositeRequis {

	public RoleSecurityComputing(String name) {
		super(name);
	}

	public void receive(DatabaseQueryMessage databaseQueryMessage) {
		this.setChanged();
		this.notifyObservers(databaseQueryMessage);
	}

}
