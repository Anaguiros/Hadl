package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceSecurityComputing extends ServiceCompositeRequis {

	public PortSecurityComputing getPortSecurityComputing() {
		return portSecurityComputing;
	}

	private PortSecurityComputing portSecurityComputing;
	
	public ServiceSecurityComputing(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portSecurityComputing = new PortSecurityComputing(portName, this);
		
		this.addPort(portName, portSecurityComputing);
	}

}
