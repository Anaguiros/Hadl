package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultat extends ServiceCompositeRequis {
	
	public ServiceResultat(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortResultat(portName));
	}
}
