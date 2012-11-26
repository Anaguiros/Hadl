package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiClient extends RoleCompositeRequis {
	
	public RoleEnvoiClient(String name) {
		super(name);
	}

	public void receive(Object object) {
		this.notifyObservers(object);
	}

}
