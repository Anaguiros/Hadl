package model.serveur.connector.clearanceRequest;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.AuthMessage;

public class RoleRequeteAuth extends RoleCompositeRequis {

	public RoleRequeteAuth(String name) {
		super(name);
	}

	public void receive(AuthMessage object) {
		this.setChanged();
		this.notifyObservers(object);
	}

}
