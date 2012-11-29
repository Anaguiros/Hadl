package model.serveur.connector.securityQuery;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;
import model.core.DatabaseResultMessage;

public class RoleSecurityResults extends RoleCompositeFourni {

	public RoleSecurityResults(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleResultatSecurity) {
			if (object instanceof DatabaseResultMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
	
}
