package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceAuthResults extends ServiceCompositeFourni {

	public ServiceAuthResults(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortAuthResults(portName));
	}

}
