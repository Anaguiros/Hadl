package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultatSecurity extends ServiceCompositeRequis {

	private PortResultatSecurity portResultatSecurity;
	
	public ServiceResultatSecurity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portResultatSecurity = new PortResultatSecurity(portName, this);
		
		this.addPort(portName, portResultatSecurity);
	}

	public PortResultatSecurity getPortResultatSecurity() {
		return portResultatSecurity;
	}

}
