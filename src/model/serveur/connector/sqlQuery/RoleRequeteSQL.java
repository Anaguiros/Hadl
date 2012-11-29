package model.serveur.connector.sqlQuery;

import java.util.Observable;
import java.util.Observer;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleRequeteSQL extends RoleCompositeFourni implements Observer {

	public RoleRequeteSQL(String name) {
		super(name);
	}
	
	public void update(Observable o, Object object) {
		if (o instanceof RoleRequete) {
			this.setChanged();
			this.notifyObservers(object);
		}
	}

}
