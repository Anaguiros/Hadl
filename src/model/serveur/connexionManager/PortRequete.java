package model.serveur.connexionManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseQueryMessage;

public class PortRequete extends PortComposantCompositeFourni {

	public PortRequete(String name, ServiceCompositeFourni service) {
		super(name, service);
	}

	public void send(DatabaseQueryMessage databaseQueryMessage) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(databaseQueryMessage);
	}
}
