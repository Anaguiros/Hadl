package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiServeur extends RoleCompositeRequis {

	
	public RoleEnvoiServeur(String name) {
		super(name);
	}

	public void receive(Object object) {
		System.out.println("RPC Reception Serveur: " + object);
		this.setChanged();
		this.notifyObservers(object);
	}
}
