package model.serveur;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;

public class PortReceptionServeur extends PortComposantCompositeRequis {

	public PortReceptionServeur(String name, ServiceCompositeRequis service) {
		super(name, service);
	}

	public void receive(Object object) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + " | Arrêt de la propagation de l'objet : aucun attachement");
		}	
		this.setChanged();
		this.notifyObservers(object);
	}
	
}
