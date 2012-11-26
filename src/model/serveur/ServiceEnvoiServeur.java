package model.serveur;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceEnvoiServeur extends ServiceCompositeFourni {

	private PortEnvoiServeur portEnvoi;
	
	public ServiceEnvoiServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portEnvoi = new PortEnvoiServeur(portName, this);
		
		this.addPort(portName, portEnvoi);
	}

	public PortEnvoiServeur getPortEnvoi() {
		return portEnvoi;
	}

	public void send(Object object) {
		this.portEnvoi.send(object);
	}

	

}
