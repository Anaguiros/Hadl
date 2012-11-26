package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequeteAuth extends ServiceCompositeFourni {
	
	private PortRequete portRequete;
	
	public ServiceRequeteAuth(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portRequete = new PortRequete(portName, this);
		
		this.addPort(portName, portRequete);
	}

	public PortRequete getPortRequete() {
		return portRequete;
	}
	
	public void send(Object object){
		this.portRequete.send(object);
	}


}
