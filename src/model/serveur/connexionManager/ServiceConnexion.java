package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexion extends ServiceCompositeRequis {
	
	public ServiceConnexion(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortConnexion(portName));
	}

}
