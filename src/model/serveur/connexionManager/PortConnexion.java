package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;

public class PortConnexion extends PortComposantCompositeRequis {

	public PortConnexion(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

}
