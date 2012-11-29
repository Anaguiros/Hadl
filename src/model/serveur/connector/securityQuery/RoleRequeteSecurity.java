package model.serveur.connector.securityQuery;

import java.util.Observable;

import metaModel.connecteur.composite.RoleCompositeFourni;
import model.core.DatabaseQueryMessage;

public class RoleRequeteSecurity extends RoleCompositeFourni {

	public RoleRequeteSecurity(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleSecurityComputing) {
			if (object instanceof DatabaseQueryMessage) {
				if (this.countObservers() == 0) {
					System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
				}
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
	
}
