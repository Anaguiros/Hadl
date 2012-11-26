package model.connecteur;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionServeur extends RoleCompositeFourni {

	public RoleReceptionServeur(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		this.notifyObservers(object);
	}
}
