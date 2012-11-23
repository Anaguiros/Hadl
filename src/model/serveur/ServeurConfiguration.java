package model.serveur;

import metaModel.configuration.Configuration;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.database.Database;
import model.serveur.securityManager.SecurityManager;

public class ServeurConfiguration extends Configuration {

//	private PortConnexionServer portConnexion;
//	private ConnexionComposantServeur connexionComposant;
	
//	private ConnexionManager connexionManager;
//	private Database database;
//	private SecurityManager securityManager;
	
	public ServeurConfiguration(String name) {
		super(name);
		
		this.addElement("ConnexionManager", new ConnexionManager("ConnexionManager"));
		this.addElement("SecurityManager", new SecurityManager("SecurityManager"));
		this.addElement("Database", new Database("Database"));
		
		this.addInterface("PortConnexionServeur", new PortConnexionServer("PortConnexionServeur"));
		this.addInterface("ConnexionComposantServeur", new ConnexionComposantServeur("ConnexionComposantServeur"));
	}

}
