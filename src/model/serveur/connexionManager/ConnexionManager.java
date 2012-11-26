package model.serveur.connexionManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;

public class ConnexionManager extends ComposantComposite implements Observer {
	
	private ServiceConnexion serviceConnexion;
	private ServiceResultat serviceResultat;
	private ServiceRequete serviceRequete;
	private ServiceResultsAuth serviceResultsAuth;
	private ServiceRequeteAuth serviceRequeteAuth;

	public ConnexionManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.serviceResultsAuth = new ServiceResultsAuth("ServiceResultsAuth");
		this.serviceRequeteAuth = new ServiceRequeteAuth("ServiceRequeteAuth");
		this.serviceRequete = new ServiceRequete("ServiceRequete");
		this.serviceResultat = new ServiceResultat("ServiceResultat");
		this.serviceConnexion = new ServiceConnexion("ServiceConnexion");
		this.serviceResultsAuth.addObserver(this);
		this.serviceResultat.addObserver(this);
		this.serviceConnexion.addObserver(this);
		this.addInterface("ServiceResultsAuth", this.serviceResultsAuth);
		this.addInterface("ServiceRequeteAuth", this.serviceRequeteAuth);
		this.addInterface("ServiceRequete", this.serviceRequete);
		this.addInterface("ServiceResultat", this.serviceResultat);
		this.addInterface("ServiceConnexion", this.serviceConnexion);
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

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceConnexion) {
			System.out.println(" o | " + this.getClass().getSimpleName() + "     | Reception depuis ServeurConfiguration");
			System.out.println(" o | " + this.getClass().getSimpleName() + "     | Renvoie vers ServeurConfiguration");
			this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
		}
		else if (o instanceof ServiceResultat) {
			this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
		}
		else if (o instanceof ServiceResultsAuth) {
			this.serviceConnexion.getPortConnexion().send(this.serviceConnexion, object);
		}
	}

}
