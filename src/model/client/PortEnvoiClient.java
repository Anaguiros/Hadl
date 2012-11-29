package model.client;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;

public class PortEnvoiClient extends PortComposantCompositeFourni {

	public PortEnvoiClient(String name, ServiceCompositeFourni service) {
		super(name, service);
	}
	
	public void send(Object object){
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(object);
	}
}
