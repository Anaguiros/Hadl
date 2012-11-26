package model.serveur;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexionConfigServeur extends ServiceCompositeRequis {

	private PortConnexionConfigServeur portConnexionConfig;
	
	public ServiceConnexionConfigServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portConnexionConfig = new PortConnexionConfigServeur(portName, this);
		
		this.addPort(portName, portConnexionConfig);
	}

	public PortConnexionConfigServeur getPortConnexionConfig() {
		return portConnexionConfig;
	}

	
}
