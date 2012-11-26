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
		System.out.println(" o | Envoi Serveur : " + message);
		ServiceEnvoiServeur serv = (ServiceEnvoiServeur)(this.getInterface("ServiceEnvoiServeur"));
		serv.send(message);
	}
	
	public void execute(Object object) {
		System.out.println(" o | Execute : " + object);
		ServiceConnexionConfigServeur serv = (ServiceConnexionConfigServeur)(this.getInterface("ServiceConnexionConfigServeur"));
		serv.send(object);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceReceptionServeur){
			System.out.println(" o | Reception Serveur : " + object);
		}
		else if (o instanceof ServiceConnexionConfigServeur) {
			System.out.println(" o | Reception from Config : " + object);
		}
	}

}
