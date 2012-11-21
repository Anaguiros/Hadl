package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeRequis;

public class ServiceResultsAuth extends PortComposantCompositeRequis {

	private PortResultsAuth portResultsAuth;
	
	public ServiceResultsAuth(String name, PortResultsAuth portResultsAuth) {
		super(name);
		this.portResultsAuth = portResultsAuth;
	}
	
	public PortResultsAuth getPortResultsAuth() {
		return this.portResultsAuth;
	}

}
