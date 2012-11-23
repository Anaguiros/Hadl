package model.client;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionClient extends ServiceCompositeRequis {

	public ServiceReceptionClient(String name){
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortReceptionClient(portName));
	}
	
}
