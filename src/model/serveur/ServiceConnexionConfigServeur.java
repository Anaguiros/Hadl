package model.serveur;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexionConfigServeur extends ServiceCompositeRequis {

//	A voir si on garde pour plus tard
//	private PortConnexionConfigServeur portConnexionConfig;
	
	public ServiceConnexionConfigServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.addPort(name, new PortConnexionConfigServeur(name));
	}

	
}
