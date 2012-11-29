package model.serveur.database;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.DatabaseResultMessage;

public class PortResultatSecurity extends PortComposantCompositeFourni {

	public PortResultatSecurity(String name, ServiceCompositeFourni service) {
		super(name, service );
		// TODO Auto-generated constructor stub
	}

	public void send(DatabaseResultMessage databaseResultMessage) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(databaseResultMessage);
	}

}
