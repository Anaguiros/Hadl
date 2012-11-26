package model.client;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceEnvoiClient extends ServiceCompositeFourni {

	private PortEnvoiClient portEnvoiClient;
	
	public ServiceEnvoiClient(String name){
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portEnvoiClient = new PortEnvoiClient(portName, this);
		
		this.addPort(portName, portEnvoiClient);
	}

	public PortEnvoiClient getPortEnvoiClient() {
		return portEnvoiClient;
	}
	
	public void sendMessage(String message){
		this.getPortEnvoiClient().sendMessage(message);
	}
}
