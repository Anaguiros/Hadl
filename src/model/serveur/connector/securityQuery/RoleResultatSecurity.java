package model.serveur.connector.securityQuery;

import metaModel.connecteur.composite.RoleCompositeRequis;
import model.core.DatabaseResultMessage;

public class RoleResultatSecurity extends RoleCompositeRequis {

	public RoleResultatSecurity(String name) {
		super(name);
	}

	public void receive(DatabaseResultMessage object) {
		this.setChanged();
		this.notifyObservers(object);
	}

}
