package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiClient extends RoleCompositeRequis {
	
	public RoleEnvoiClient(String name) {
		super(name);
	}

	public void receive(Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "      | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(object);
	}

}
