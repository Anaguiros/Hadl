package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultat extends ServiceCompositeRequis {
	
	private PortResultat portResultat;
	
	public ServiceResultat(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portResultat = new PortResultat(portName, this);
		
		this.addPort(portName, portResultat);
	}

	public PortResultat getPortResultat() {
		return portResultat;
	}
}
