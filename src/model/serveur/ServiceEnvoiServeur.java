package model.serveur;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceEnvoiServeur extends ServiceCompositeFourni {

//	A voir si on garde pour plus tard
//	private PortEnvoiServeur portEnvoi;
	
	public ServiceEnvoiServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortEnvoiServeur(portName));
	}

	

}
