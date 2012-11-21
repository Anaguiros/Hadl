package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequete extends ServiceCompositeFourni {

	private PortRequete portRequete;
	
	public ServiceRequete(String name, PortRequete portRequete) {
		super(name);
		this.portRequete = portRequete;
	}

	public PortRequete getPortRequete() {
		return this.portRequete;
	}
}
