package model.serveur.connector.clearanceRequest;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.ResponseMessage;

public class RoleAuthResults extends RoleCompositeRequis {

	public RoleAuthResults(String name) {
		super(name);
	}

	public void receive(ResponseMessage responseMessage) {
		this.setChanged();
		this.notifyObservers(responseMessage);
	}

}
