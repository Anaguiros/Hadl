package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequete extends ServiceCompositeFourni {
	
	public ServiceRequete(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortRequete(portName));
	}

}
