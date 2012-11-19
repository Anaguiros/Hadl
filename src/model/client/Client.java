package model.client;

import metaModel.composant.composite.ComposantComposite;

public class Client extends ComposantComposite{

	public Client(String name) {
		super(name);
		this.addProprieteFonctionnelle("Code Source", null);
		this.addProprieteNonFonctionnelle("Performance Data", null);
		
		this.addInterface("ServiceReceptionClient", new ServiceReceptionClient("Service Reception Client"));
		this.addInterface("ServiceEnvoiClient", new ServiceEnvoiClient("Service Envoi Client"));
	}

}
