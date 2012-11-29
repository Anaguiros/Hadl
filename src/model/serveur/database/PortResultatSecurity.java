package model.serveur.database;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseResultMessage;

public class PortResultatSecurity extends PortComposantCompositeFourni {

	public PortResultatSecurity(String name, ServiceCompositeFourni service) {
		super(name, service );
		// TODO Auto-generated constructor stub
	}

	public void send(DatabaseResultMessage databaseResultMessage) {
		this.setChanged();
		this.notifyObservers(databaseResultMessage);
	}

}
