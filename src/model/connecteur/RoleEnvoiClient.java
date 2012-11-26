package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiClient extends RoleCompositeRequis {
	
	public RoleEnvoiClient(String name) {
		super(name);
	}

	public void receive(Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | Arrêt de la propagation de l'objet : aucun attachement sur RoleEnvoiClient");
		}
		else {
			System.out.println(" o | RPC Client -> Serveur : " + object);
		}
		this.setChanged();
		this.notifyObservers(object);
	}

}
