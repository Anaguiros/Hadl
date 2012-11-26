package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceSecurityResults extends ServiceCompositeFourni {

	private PortSecurityResults portSecurityResults;
	
	public ServiceSecurityResults(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portSecurityResults = new PortSecurityResults(portName, this);
		
		this.addPort(portName, portSecurityResults);
	}

	public PortSecurityResults getPortSecurityResults() {
		return portSecurityResults;
	}

}
