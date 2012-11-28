package model.serveur.connector.sqlQuery;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.DatabaseResultMessage;

public class RoleResultatSQL extends RoleCompositeRequis {

	public RoleResultatSQL(String name) {
		super(name);
	}
	
	public void receive(DatabaseResultMessage databaseResultMessage) {
		this.setChanged();
		this.notifyObservers(databaseResultMessage);
	}

}
