package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseResultMessage;

public class PortResultat extends PortComposantCompositeRequis {

	public PortResultat(String name, ServiceCompositeRequis service) {
		super(name, service);
	}
	
	public void receive(DatabaseResultMessage databaseResultMessage) {
		this.setChanged();
		this.notifyObservers(databaseResultMessage);
	}

}
