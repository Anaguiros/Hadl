package model.client;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceEnvoiClient extends ServiceCompositeFourni {

	public ServiceEnvoiClient(String name){
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortEnvoiClient(portName));
	}
	
}
