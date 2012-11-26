package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequete extends ServiceCompositeFourni {
	
	private PortRequete portRequete;
	
	public ServiceRequete(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portRequete = new PortRequete(portName, this);
		
		this.addPort(portName, portRequete);
	}

	public PortRequete getPortRequete() {
		return portRequete;
	}

}
