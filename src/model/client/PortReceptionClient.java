package model.client;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;

public class PortReceptionClient extends PortComposantCompositeRequis {

	public PortReceptionClient(String name, ServiceCompositeRequis service){
		super(name, service);
	}
	
	public void receive(Object object) {
		this.setChanged();
		this.notifyObservers(object);
	}
	
}
