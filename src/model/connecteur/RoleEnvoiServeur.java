package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiServeur extends RoleCompositeRequis {

	
	public RoleEnvoiServeur(String name) {
		super(name);
	}

	public void receive(Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arrêt de la propagation de l'objet : aucun attachement");
		}
		else {
			System.out.println(" o | " + this.getClass().getSimpleName() + "     | RPC Serveur -> Client : " + object);
		}
		this.setChanged();
		this.notifyObservers(object);
	}
}
