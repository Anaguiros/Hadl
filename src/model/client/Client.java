package model.client;

import metaModel.composant.composite.ComposantComposite;

public class Client extends ComposantComposite{

	public Client(String name) {
		super(name);
		this.addProprieteFonctionnelle("Code Source", null);
		this.addProprieteNonFonctionnelle("Performance Data", null);
		
		this.addInterface("ServiceReceptionClient", new ServiceReceptionClient("ServiceReceptionClient"));
		this.addInterface("ServiceEnvoiClient", new ServiceEnvoiClient("ServiceEnvoiClient"));
	}

	public void sendMessage(String message){
		ServiceEnvoiClient serv = (ServiceEnvoiClient)(this.getInterface("ServiceEnvoiClient"));
		serv.sendMessage(message);
	}
	
}
