package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceAuthComputing extends ServiceCompositeRequis {

	private PortAuthComputing portAuthComputing;
	
	public ServiceAuthComputing(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portAuthComputing = new PortAuthComputing(portName, this);
		
		this.addPort(portName, portAuthComputing);
	}

	public PortAuthComputing getPortAuthComputing() {
		return portAuthComputing;
	}

}
