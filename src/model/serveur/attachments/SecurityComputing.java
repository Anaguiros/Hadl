package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.core.DatabaseQueryMessage;
import model.serveur.connector.securityQuery.RoleSecurityComputing;
import model.serveur.securityManager.PortSecurityComputing;

public class SecurityComputing extends AttachmentFourni {

	public SecurityComputing(PortComposantCompositeFourni portCompo, RoleCompositeRequis role) {
		super(portCompo, role);
		this.portCompo.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortSecurityComputing) {
			if (object instanceof DatabaseQueryMessage) {
				((RoleSecurityComputing) this.role).receive((DatabaseQueryMessage) object);
			}
		}
	}

}
