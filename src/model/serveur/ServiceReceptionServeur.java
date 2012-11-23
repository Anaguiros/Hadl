package model.serveur;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionServeur extends ServiceCompositeRequis {

//	A voir si on garde pour plus tard
//	private PortReceptionServeur portReception;
	
	public ServiceReceptionServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortReceptionServeur(portName));
	}

	
	
}
