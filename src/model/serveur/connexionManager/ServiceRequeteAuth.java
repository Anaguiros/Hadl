package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeFourni;

public class ServiceRequeteAuth extends ServiceCompositeFourni {

	private PortRequeteAuth portRequeteAuth;
	
	public ServiceRequeteAuth(String name, PortRequeteAuth portRequeteAuth) {
		super(name);
		this.portRequeteAuth = portRequeteAuth;
	}

	public PortRequeteAuth getPortRequeteAuth() {
		return this.portRequeteAuth;
	}
}
