package model.serveur.connector.clearanceRequest;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.AuthMessage;

public class RoleRequeteAuth extends RoleCompositeRequis {

	public RoleRequeteAuth(String name) {
		super(name);
	}

	public void receive(AuthMessage object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(object);
	}

}
