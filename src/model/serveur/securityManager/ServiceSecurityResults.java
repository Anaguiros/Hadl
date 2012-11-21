package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceSecurityResults extends ServiceCompositeFourni {

	public ServiceSecurityResults(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortSecurityResults(portName));
	}

}
