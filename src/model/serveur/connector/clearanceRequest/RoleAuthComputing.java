package model.serveur.connector.clearanceRequest;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;
import model.core.AuthMessage;

public class RoleAuthComputing extends RoleCompositeFourni {

	public RoleAuthComputing(String name) {
		super(name);
	}
	
	public void update(Observable o, Object object) {
		if (o instanceof RoleRequeteAuth) {
			if (object instanceof AuthMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}

}
