package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceAuthComputing extends ServiceCompositeRequis {

	public ServiceAuthComputing(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortAuthComputing(portName));
	}

}
