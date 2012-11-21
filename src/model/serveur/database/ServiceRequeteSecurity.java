package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequeteSecurity extends ServiceCompositeFourni {

	public ServiceRequeteSecurity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortRequeteSecurity(portName));
	}

}
