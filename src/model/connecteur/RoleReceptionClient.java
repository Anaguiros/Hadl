package model.connecteur;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionClient extends RoleCompositeFourni {
	
	public RoleReceptionClient(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		this.notifyObservers(object);
	}

}
