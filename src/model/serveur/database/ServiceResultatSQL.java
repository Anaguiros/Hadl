package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceResultatSQL extends ServiceCompositeFourni {

	public ServiceResultatSQL(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortResultatSQL(portName));
	}

}
