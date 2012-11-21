package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultatSecurity extends ServiceCompositeRequis {

	public ServiceResultatSecurity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortResultatSecurity(portName));
	}

}
