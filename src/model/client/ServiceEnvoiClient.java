package model.client;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceEnvoiClient extends ServiceCompositeFourni {

	public ServiceEnvoiClient(String name){
		super(name);
		this.addPort(name, new PortEnvoiClient(name));
	}
	
}
