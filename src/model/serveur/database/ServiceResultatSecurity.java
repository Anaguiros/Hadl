package model.serveur.database;

import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseResultMessage;

public class ServiceResultatSecurity extends ServiceCompositeFourni {

	private PortResultatSecurity portResultatSecurity;
	
	public ServiceResultatSecurity(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portResultatSecurity = new PortResultatSecurity(portName, this);
		
		this.addPort(portName, portResultatSecurity);
	}

	public PortResultatSecurity getPortResultatSecurity() {
		return portResultatSecurity;
	}

	public void send(DatabaseResultMessage databaseResultMessage) {
		this.portResultatSecurity.send(databaseResultMessage);
	}

}
