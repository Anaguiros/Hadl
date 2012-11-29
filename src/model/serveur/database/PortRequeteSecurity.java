package model.serveur.database;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseQueryMessage;

public class PortRequeteSecurity extends PortComposantCompositeRequis {

	public PortRequeteSecurity(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(DatabaseQueryMessage object) {
		this.setChanged();
		this.notifyObservers(object);
	}

}
