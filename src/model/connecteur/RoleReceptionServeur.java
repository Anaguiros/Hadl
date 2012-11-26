package model.connecteur;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionServeur extends RoleCompositeFourni {

	public RoleReceptionServeur(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | Arrêt de la propagation de l'objet : aucun attachement sur RoleReceptionServeur");
		}
		else {
			System.out.println(" o | RPC Client -> " + this.countObservers() + " Serveur : " + object);
		}
		this.setChanged();
		this.notifyObservers(object);
	}
}
