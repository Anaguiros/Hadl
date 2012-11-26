package model.connecteur;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionClient extends RoleCompositeFourni {
	
	public RoleReceptionClient(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		System.out.println("RPC Envoi vers " + this.countObservers() + " Client : " + object);
		this.setChanged();
		this.notifyObservers(object);
	}

}
