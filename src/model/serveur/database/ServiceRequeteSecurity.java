package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequeteSecurity extends ServiceCompositeFourni {

	private PortRequeteSecurity portRequeteSecurity;
	
	public ServiceRequeteSecurity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portRequeteSecurity = new PortRequeteSecurity(portName, this);
		
		this.addPort(portName, portRequeteSecurity);
	}

	public PortRequeteSecurity getPortRequeteSecurity() {
		return portRequeteSecurity;
	}

}
