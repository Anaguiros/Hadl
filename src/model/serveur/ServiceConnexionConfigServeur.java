package model.serveur;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexionConfigServeur extends ServiceCompositeRequis {

//	A voir si on garde pour plus tard
//	private PortConnexionConfigServeur portConnexionConfig;
	
	public ServiceConnexionConfigServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortConnexionConfigServeur(portName));
	}

	
}
