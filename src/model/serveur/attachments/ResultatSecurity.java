package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.core.DatabaseResultMessage;
import model.serveur.connector.securityQuery.RoleResultatSecurity;
import model.serveur.database.PortResultatSecurity;

public class ResultatSecurity extends AttachmentFourni {

	public ResultatSecurity(PortComposantCompositeFourni portCompo, RoleCompositeRequis role) {
		super(portCompo, role);
		this.portCompo.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortResultatSecurity) {
			if (object instanceof DatabaseResultMessage) {
				((RoleResultatSecurity) this.role).receive((DatabaseResultMessage) object);
			}
		}
	}

}
