package model.connecteur;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionClient extends RoleCompositeFourni {
	
	public RoleReceptionClient(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | Arrêt de la propagation de l'objet : aucun attachement sur RoleReceptionClient");
		}
		else {
			System.out.println(" o | RPC Serveur -> " + this.countObservers() + " Client : " + object);
		}
		this.setChanged();
		this.notifyObservers(object);
	}

}
