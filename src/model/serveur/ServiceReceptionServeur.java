package model.serveur;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionServeur extends ServiceCompositeRequis {

	private PortReceptionServeur portReception;
	
	public ServiceReceptionServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portReception = new PortReceptionServeur(portName, this);
		
		this.addPort(portName, portReception);
	}

	public PortReceptionServeur getPortReception() {
		return portReception;
	}

	
	
}
