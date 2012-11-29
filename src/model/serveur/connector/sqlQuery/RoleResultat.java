package model.serveur.connector.sqlQuery;

import java.util.Observable;
import java.util.Observer;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleResultat extends RoleCompositeFourni implements Observer {

	public RoleResultat(String name) {
		super(name);
	}

	public void update(Observable o, Object object) {
		if (o instanceof RoleResultatSQL) {
			this.setChanged();
			this.notifyObservers(object);
		}
	}
}
