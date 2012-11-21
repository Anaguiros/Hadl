package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexion extends ServiceCompositeRequis {

	private PortConnexion portConnexion;
	
	public ServiceConnexion(String name, PortConnexion portConnexion) {
		super(name);
		this.portConnexion = portConnexion;
	}
	
	public PortConnexion getPortConnexion() {
		return this.portConnexion;
	}

}
