package model.serveur;

import metaModel.configuration.Configuration;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.database.Database;

public class ServeurConfiguration extends Configuration {

	private PortConnexionServer portConnexion;
	private ConnexionComposantServeur connexionComposant;
	
	private ConnexionManager connexionManager;
	private Database database;
	private SecurityManager securityManager;
	
	public ServeurConfiguration(String name) {
		super(name);
	}

	public PortConnexionServer getPortConnexion() {
		return portConnexion;
	}

	public void setPortConnexion(PortConnexionServer portConnexion) {
		this.portConnexion = portConnexion;
	}

	public ConnexionComposantServeur getConnexionComposant() {
		return connexionComposant;
	}

	public void setConnexionComposant(ConnexionComposantServeur connexionComposant) {
		this.connexionComposant = connexionComposant;
	}

	public ConnexionManager getConnexionManager() {
		return connexionManager;
	}

	public void setConnexionManager(ConnexionManager connexionManager) {
		this.connexionManager = connexionManager;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public SecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(SecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
