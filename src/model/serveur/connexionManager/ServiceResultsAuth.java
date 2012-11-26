package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultsAuth extends ServiceCompositeRequis {
	
	private PortResultsAuth portResultsAuth;
	
	public ServiceResultsAuth(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portResultsAuth = new PortResultsAuth(portName, this);
		
		this.addPort(portName, portResultsAuth);
	}

	public PortResultsAuth getPortResultsAuth() {
		return portResultsAuth;
	}

}
