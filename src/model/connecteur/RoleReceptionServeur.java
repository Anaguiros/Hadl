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
			System.out.println(" x | " + this.getClass().getSimpleName() + " | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(object);
	}
}
