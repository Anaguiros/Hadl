package model.client;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;

public class Client extends ComposantComposite implements Observer {

	public Client(String name) {
		super(name);
		this.addProprieteFonctionnelle("Code Source", null);
		this.addProprieteNonFonctionnelle("Performance Data", null);
		
		ServiceReceptionClient src = new ServiceReceptionClient("ServiceReceptionClient");
		this.addInterface("ServiceReceptionClient", src);
		this.addInterface("ServiceEnvoiClient", new ServiceEnvoiClient("ServiceEnvoiClient"));
		src.addObserver(this);
		
	}

	public void sendMessage(String message){
		System.out.println(" o | Envoi Client : " + message);
		ServiceEnvoiClient serv = (ServiceEnvoiClient)(this.getInterface("ServiceEnvoiClient"));
		serv.sendMessage(message);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceReceptionClient){
			System.out.println(" o | Reception Client : " + object);
		}
	}
	
}
