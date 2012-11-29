package model.serveur.connector.securityQuery;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;
import model.core.DatabaseResultMessage;

public class RoleSecurityResults extends RoleCompositeFourni {

	public RoleSecurityResults(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleResultatSecurity) {
			if (object instanceof DatabaseResultMessage) {
				if (this.countObservers() == 0) {
					System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
				}
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
	
}
