package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;
import model.client.PortEnvoiClient;

public class ServiceRequeteAuth extends ServiceCompositeFourni {
	
	public ServiceRequeteAuth(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortRequeteAuth(portName));
	}


}
