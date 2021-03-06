package model.serveur.securityManager;

import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.ResponseMessage;

public class ServiceAuthResults extends ServiceCompositeFourni {

	private PortAuthResults portAuthResults;
	
	public ServiceAuthResults(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portAuthResults = new PortAuthResults(portName, this);
		
		this.addPort(portName, portAuthResults);
	}

	public PortAuthResults getPortAuthResults() {
		return portAuthResults;
	}

	public void send(ResponseMessage responseMessage) {
		((PortAuthResults) this.portAuthResults).send(responseMessage);
	}

}
