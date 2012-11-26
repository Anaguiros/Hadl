package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.serveur.connexionManager.PortResultsAuth;

public class ServiceRequeteSQL extends ServiceCompositeRequis {

	private PortRequeteSQL portRequeteSQL;
	
	public ServiceRequeteSQL(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portRequeteSQL = new PortRequeteSQL(portName, this);
		
		this.addPort(portName, portRequeteSQL);
	}

	public PortRequeteSQL getPortRequeteSQL() {
		return portRequeteSQL;
	}

}
