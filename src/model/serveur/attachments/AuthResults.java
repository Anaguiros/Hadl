package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.core.ResponseMessage;
import model.serveur.connector.clearanceRequest.RoleAuthResults;
import model.serveur.securityManager.PortAuthResults;

public class AuthResults extends AttachmentFourni {

	public AuthResults(PortComposantCompositeFourni portCompo, RoleCompositeRequis role) {
		super(portCompo, role);
		this.portCompo.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortAuthResults) {
			if (object instanceof ResponseMessage) {
				((RoleAuthResults) this.role).receive((ResponseMessage) object);
			}
		}
	}

}
