package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.core.DatabaseResultMessage;
import model.serveur.connector.securityQuery.RoleSecurityResults;
import model.serveur.securityManager.PortSecurityResults;

public class SecurityResults extends AttachmentRequis {

	public SecurityResults(PortComposantCompositeRequis portCompo, RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleSecurityResults) {
			if (object instanceof DatabaseResultMessage) {
				((PortSecurityResults) this.portCompo).receive((DatabaseResultMessage) object);
			}
		}
	}

}
