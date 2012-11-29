package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequeteAuth extends ServiceCompositeFourni {
	
	private PortRequeteAuth portRequeteAuth;
	
	public ServiceRequeteAuth(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portRequeteAuth = new PortRequeteAuth(portName, this);
		
		this.addPort(portName, portRequeteAuth);
	}

	public PortRequeteAuth getPortRequeteAuth() {
		return portRequeteAuth;
	}
	
	public void send(Object object){
		this.portRequeteAuth.send(object);
	}


}
