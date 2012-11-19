package model.serveur;

import metaModel.composant.composite.ComposantComposite;

public class ServeurComposant extends ComposantComposite {
	
//	private ServiceEnvoiServeur serviceEnvoi;
//	private ServiceReceptionServeur serviceReception;
//	private ServiceConnexionConfigServeur serviceConnexionConfig;
	

	public ServeurComposant(String name) {
		super(name);
		this.addInterface("ServiceEnvoiServeur", new ServiceEnvoiServeur("Service Envoi Serveur"));
		this.addInterface("ServiceReceptionServeur", new ServiceEnvoiServeur("Service Reception Serveur"));
		this.addInterface("ServiceConnexionConfigServeur", new ServiceEnvoiServeur("Service Connexion ConfigServeur"));
	}

}
