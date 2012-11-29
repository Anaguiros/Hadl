package model.serveur.connector.clearanceRequest;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;
import model.core.ResponseMessage;

public class RoleResultsAuth extends RoleCompositeFourni {

	public RoleResultsAuth(String name) {
		super(name);
	}
	
	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleAuthResults) {
			if (object instanceof ResponseMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}

}
