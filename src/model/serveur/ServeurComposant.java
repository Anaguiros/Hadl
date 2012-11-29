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
		ServiceConnexionConfigServeur sccs = new ServiceConnexionConfigServeur("ServiceConnexionConfigServeur");
		this.addInterface("ServiceEnvoiServeur", new ServiceEnvoiServeur("ServiceEnvoiServeur"));
		this.addInterface("ServiceReceptionServeur", srs);
		this.addInterface("ServiceConnexionConfigServeur", sccs);
		
		srs.addObserver(this);
		sccs.addObserver(this);
	}
	
	public void send(Object message){
		System.out.println(" o | " + this.getClass().getSimpleName() + "     | \tTransfert de la reponse");
		ServiceEnvoiServeur serv = (ServiceEnvoiServeur)(this.getInterface("ServiceEnvoiServeur"));
		System.out.println("<- | " + this.getClass().getSimpleName() + "     | Send to Client : " + message);
		serv.send(message);
	}
	
	public void execute(Object object) {
		System.out.println(" o | " + this.getClass().getSimpleName() + "     | \tTransfert de la requete");
		ServiceConnexionConfigServeur serv = (ServiceConnexionConfigServeur)(this.getInterface("ServiceConnexionConfigServeur"));
		System.out.println("<- | " + this.getClass().getSimpleName() + "     | Send to ServeurConfiguration : " + object);
		serv.send(object);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceReceptionServeur){
			System.out.println("-> | " + this.getClass().getSimpleName() + "     | Reception from Client : " + object);
			this.execute(object);
		}
		else if (o instanceof ServiceConnexionConfigServeur) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "     | Reception from ServeurConfiguration : " + object);
			this.send(object);
		}
	}

}
