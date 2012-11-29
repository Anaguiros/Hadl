package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;

public class PortRequeteAuth extends PortComposantCompositeFourni {

	public PortRequeteAuth(String name, ServiceCompositeFourni service) {
		super(name, service);
	}

	public void send(Object object){
		this.setChanged();
		this.notifyObservers(object);
	}
}
