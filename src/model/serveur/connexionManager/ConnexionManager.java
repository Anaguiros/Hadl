package model.serveur.connexionManager;

import metaModel.composant.composite.ComposantComposite;

public class ConnexionManager extends ComposantComposite {
	
	private ServiceConnexion serviceConnexion;
	private ServiceResultat serviceResultat;
	private ServiceRequete serviceRequete;
	private ServiceResultsAuth serviceResultsAuth;
	private ServiceRequeteAuth serviceRequeteAuth;

	public ConnexionManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.addInterface("ServiceResultsAuth", new ServiceResultsAuth("ServiceResultsAuth"));
		this.addInterface("ServiceRequeteAuth", new ServiceRequeteAuth("ServiceRequeteAuth"));
		this.addInterface("ServiceRequete", new ServiceRequete("ServiceRequete"));
		this.addInterface("ServiceResultat", new ServiceResultat("ServiceResultat"));
		
		this.addInterface("ServiceConnexion", new ServiceConnexion("ServiceConnexion"));
	}

	public ServiceConnexion getServiceConnexion() {
		return serviceConnexion;
	}

	public void setServiceConnexion(ServiceConnexion serviceConnexion) {
		this.serviceConnexion = serviceConnexion;
	}

	public ServiceRequeteAuth getServiceRequeteAuth() {
		return serviceRequeteAuth;
	}

	public void setServiceRequeteAuth(ServiceRequeteAuth serviceRequeteAuth) {
		this.serviceRequeteAuth = serviceRequeteAuth;
	}

	public ServiceResultsAuth getServiceResultsAuth() {
		return serviceResultsAuth;
	}

	public void setServiceResultsAuth(ServiceResultsAuth serviceResultsAuth) {
		this.serviceResultsAuth = serviceResultsAuth;
	}

	public ServiceRequete getServiceRequete() {
		return serviceRequete;
	}

	public void setServiceRequete(ServiceRequete serviceRequete) {
		this.serviceRequete = serviceRequete;
	}

	public ServiceResultat getServiceResultat() {
		return serviceResultat;
	}

	public void setServiceResultat(ServiceResultat serviceResultat) {
		this.serviceResultat = serviceResultat;
	}

}
