package model.serveur;

import metaModel.configuration.Configuration;
import metaModel.configuration.PortConfigRequis;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.database.Database;

public class ServeurConfiguration extends Configuration {

	private PortConnexionServer portConnexion;
	private ConnexionComposantServeur connexionComposant;
	
//	private ConnexionManager connexionManager;
//	private Database database;
//	private SecurityManager securityManager;
	
	public ServeurConfiguration(String name) {
		super(name);
		
		this.addElement("ConnexionManager", new ConnexionManager("ConnexionManager"));
//		this.addElement("SecurityManager", element);
//		this.addElement("Database", element);
		
		this.addInterface("PortConnexionServeur", new PortConnexionServer("PortConnexionServeur"));
		this.addInterface("ConnexionComposantServeur", new ConnexionComposantServeur("ConnexionComposantServeur"));
	}

}
