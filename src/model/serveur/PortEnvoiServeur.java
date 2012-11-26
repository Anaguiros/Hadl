package model.serveur;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;

public class PortEnvoiServeur extends PortComposantCompositeFourni {

	public PortEnvoiServeur(String name, ServiceCompositeFourni service) {
		super(name, service);
	}

}
