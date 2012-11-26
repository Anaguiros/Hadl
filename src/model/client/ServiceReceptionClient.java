package model.client;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionClient extends ServiceCompositeRequis {
	
	private PortReceptionClient portReceptionClient;

	public ServiceReceptionClient(String name){
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portReceptionClient = new PortReceptionClient(portName, this);
		
		this.addPort(portName, portReceptionClient);
	}

	public PortReceptionClient getPortReceptionClient() {
		return portReceptionClient;
	}
	
}
