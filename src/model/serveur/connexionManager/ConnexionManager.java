package model.serveur.connexionManager;

public class ConnexionManager {

	private ServiceConnexion serviceConnexion;
	private ServiceResultat serviceResultat;
	private ServiceRequete serviceRequete;
	private ServiceResultsAuth serviceResultsAuth;
	private ServiceRequeteAuth serviceRequeteAuth;
	
	public ConnexionManager() {
		// TODO Auto-generated constructor stub
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
