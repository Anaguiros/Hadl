package model.serveur.connexionManager;

import metaModel.composant.composite.ComposantComposite;

public class ConnexionManager extends ComposantComposite {

	public ConnexionManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.addInterface("ServiceResultsAuth", new ServiceResultsAuth("ServiceResultsAuth"));
		this.addInterface("ServiceRequeteAuth", new ServiceRequeteAuth("ServiceRequeteAuth"));
		this.addInterface("ServiceRequete", new ServiceRequete("ServiceRequete"));
		this.addInterface("ServiceResultat", new ServiceResultat("ServiceResultat"));
		
		this.addInterface("ServiceConnexion", new ServiceConnexion("ServiceConnexion"));
	}

}
