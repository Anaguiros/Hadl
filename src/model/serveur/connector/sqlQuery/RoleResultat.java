package model.serveur.connector.sqlQuery;

import java.util.Observable;
import java.util.Observer;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleResultat extends RoleCompositeFourni implements Observer {

	public RoleResultat(String name) {
		super(name);
	}

	public void update(Observable o, Object object) {
		if (o instanceof RoleResultatSQL) {
			if (this.countObservers() == 0) {
				System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
			}
			this.setChanged();
			this.notifyObservers(object);
		}
	}
}
