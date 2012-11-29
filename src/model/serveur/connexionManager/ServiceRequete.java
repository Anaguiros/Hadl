package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseQueryMessage;

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

	public void send(DatabaseQueryMessage databaseQueryMessage) {
		this.portRequete.send(databaseQueryMessage);
	}
}
