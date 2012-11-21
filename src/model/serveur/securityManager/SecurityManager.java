package model.serveur.securityManager;

import metaModel.composant.composite.ComposantComposite;

public class SecurityManager extends ComposantComposite {

	public SecurityManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.addInterface("ServiceAuthResults", new ServiceAuthResults("ServiceAuthResults"));
		this.addInterface("ServiceAuthComputing", new ServiceAuthComputing("ServiceAuthComputing"));
		this.addInterface("ServiceSecurityResults", new ServiceSecurityResults("ServiceSecurityResults"));
		this.addInterface("ServiceSecurityComputing", new ServiceSecurityComputing("ServiceSecurityComputing"));
	}


}
