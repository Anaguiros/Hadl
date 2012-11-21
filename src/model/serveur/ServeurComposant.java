package model.serveur;

import metaModel.composant.composite.ComposantComposite;

public class ServeurComposant extends ComposantComposite {
	
//	private ServiceEnvoiServeur serviceEnvoi;
//	private ServiceReceptionServeur serviceReception;
//	private ServiceConnexionConfigServeur serviceConnexionConfig;
	

	public ServeurComposant(String name) {
		super(name);
		
		this.addInterface("ServiceEnvoiServeur", new ServiceEnvoiServeur("ServiceEnvoiServeur"));
		this.addInterface("ServiceReceptionServeur", new ServiceReceptionServeur("ServiceReceptionServeur"));
		this.addInterface("ServiceConnexionConfigServeur", new ServiceConnexionConfigServeur("ServiceConnexionConfigServeur"));
	}

}
