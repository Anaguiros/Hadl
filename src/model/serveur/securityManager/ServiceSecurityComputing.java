package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseQueryMessage;

public class ServiceSecurityComputing extends ServiceCompositeFourni {

	public PortSecurityComputing getPortSecurityComputing() {
		return portSecurityComputing;
	}

	private PortSecurityComputing portSecurityComputing;
	
	public ServiceSecurityComputing(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portSecurityComputing = new PortSecurityComputing(portName, this);
		
		this.addPort(portName, portSecurityComputing);
	}
	
	public void send(DatabaseQueryMessage databaseQueryMessage) {
		this.portSecurityComputing.send(databaseQueryMessage);
	}

}
