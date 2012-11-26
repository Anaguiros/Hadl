package model.serveur;

import java.util.Observable;
import java.util.Observer;

import metaModel.configuration.Configuration;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.database.Database;
import model.serveur.securityManager.SecurityManager;

public class ServeurConfiguration extends Configuration implements Observer {

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
		
		ConnexionComposantServeur ccs = new ConnexionComposantServeur("ConnexionComposantServeur");
		this.addInterface("PortConnexionServeur", new PortConnexionServer("PortConnexionServeur"));
		this.addInterface("ConnexionComposantServeur", ccs);
		ccs.addObserver(this);
	}

	public void send(Object object) {
		System.out.println(" o | Envoi vers Serveur : " + object);
		ConnexionComposantServeur serv = (ConnexionComposantServeur)(this.getInterface("ConnexionComposantServeur"));
		serv.send(object);
	}
	
	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ConnexionComposantServeur) {
			System.out.println(" o | Reception from Serveur : " + object);
		}
	}

}
