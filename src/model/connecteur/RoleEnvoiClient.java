package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiClient extends RoleCompositeRequis {
	
	public RoleEnvoiClient(String name) {
		super(name);
	}

	public void receive(Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "      | Arrêt de la propagation de l'objet : aucun attachement");
		}
		else {
			System.out.println(" o | " + this.getClass().getSimpleName() + "      | RPC Client -> Serveur : " + object);
		}
		this.setChanged();
		this.notifyObservers(object);
	}

}
