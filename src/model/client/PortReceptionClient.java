package model.client;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;

public class PortReceptionClient extends PortComposantCompositeRequis {

	public PortReceptionClient(String name, ServiceCompositeRequis service){
		super(name, service);
	}
	
	public void receive(Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | Arrêt de la propagation de l'objet : aucun attachement sur PortReceptionClient");
		}
		this.setChanged();
		this.notifyObservers(object);
	}
	
}
