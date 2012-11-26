package model.serveur;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;

public class ServeurComposant extends ComposantComposite implements Observer {
	
//	private ServiceEnvoiServeur serviceEnvoi;
//	private ServiceReceptionServeur serviceReception;
//	private ServiceConnexionConfigServeur serviceConnexionConfig;
	

	public ServeurComposant(String name) {
		super(name);
		
		ServiceReceptionServeur srs = new ServiceReceptionServeur("ServiceReceptionServeur");
		this.addInterface("ServiceEnvoiServeur", new ServiceEnvoiServeur("ServiceEnvoiServeur"));
		this.addInterface("ServiceReceptionServeur", srs);
		this.addInterface("ServiceConnexionConfigServeur", new ServiceConnexionConfigServeur("ServiceConnexionConfigServeur"));
		
		srs.addObserver(this);
	}
	
	public void sendMessage(String message){
		System.out.println("Envoi Serveur : " + message);
		ServiceEnvoiServeur serv = (ServiceEnvoiServeur)(this.getInterface("ServiceEnvoiServeur"));
		serv.send(message);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceReceptionServeur){
			System.out.println("Reception Serveur : " + object);
		}
	}

}
