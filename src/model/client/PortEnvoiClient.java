package model.client;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;

public class PortEnvoiClient extends PortComposantCompositeFourni {

	public PortEnvoiClient(String name, ServiceCompositeFourni service) {
		super(name, service);
	}
	
}
