package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceSecurityComputing extends ServiceCompositeRequis {

	public ServiceSecurityComputing(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortSecurityComputing(portName));
	}

}
