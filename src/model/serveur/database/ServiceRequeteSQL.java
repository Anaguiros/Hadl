package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.serveur.connexionManager.PortResultsAuth;

public class ServiceRequeteSQL extends ServiceCompositeRequis {

	public ServiceRequeteSQL(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		this.addPort(portName, new PortRequeteSQL(portName));
	}

}
