package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.core.DatabaseQueryMessage;
import model.serveur.connector.securityQuery.RoleRequeteSecurity;
import model.serveur.database.PortRequeteSecurity;

public class RequeteSecurity extends AttachmentRequis {

	public RequeteSecurity(PortComposantCompositeRequis portCompo, RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleRequeteSecurity) {
			if (object instanceof DatabaseQueryMessage) {
				((PortRequeteSecurity) this.portCompo).receive((DatabaseQueryMessage) object);
			}
		}
	}

}
