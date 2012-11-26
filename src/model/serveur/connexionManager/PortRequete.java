package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;

public class PortRequete extends PortComposantCompositeFourni {

	public PortRequete(String name, ServiceCompositeFourni service) {
		super(name, service);
	}

}
