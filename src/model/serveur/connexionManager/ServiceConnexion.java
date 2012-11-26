package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexion extends ServiceCompositeRequis {
	
	private PortConnexion portConnexion;
	
	public ServiceConnexion(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portConnexion = new PortConnexion(portName, this);
		
		this.addPort(portName, portConnexion);
	}

	public PortConnexion getPortConnexion() {
		return portConnexion;
	}

}
