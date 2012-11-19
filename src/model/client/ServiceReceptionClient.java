package model.client;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionClient extends ServiceCompositeRequis {

	public ServiceReceptionClient(String name){
		super(name);
		this.addPort(name, new PortReceptionClient(name));
	}
	
}
