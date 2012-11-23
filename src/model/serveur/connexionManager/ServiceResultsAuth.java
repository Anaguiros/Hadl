package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultsAuth extends ServiceCompositeRequis {
	
	public ServiceResultsAuth(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortResultsAuth(portName));
	}

}
