package model.serveur;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;

public class PortReceptionServeur extends PortComposantCompositeRequis {

	public PortReceptionServeur(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(Object object) {
		this.setChanged();
		this.notifyObservers(object);
	}
	
}
