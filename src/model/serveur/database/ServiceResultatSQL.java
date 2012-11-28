package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseResultMessage;

public class ServiceResultatSQL extends ServiceCompositeFourni {

	private PortResultatSQL portResultatSQL;
	
	public ServiceResultatSQL(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portResultatSQL = new PortResultatSQL(portName, this);
		this.addPort(portName, portResultatSQL);
	}

	public PortResultatSQL getPortResultatSQL() {
		return portResultatSQL;
	}

	public void send(DatabaseResultMessage databaseResultMessage) {
		((PortResultatSQL) this.portResultatSQL).send(databaseResultMessage);
	}

}
