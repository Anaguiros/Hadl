package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.core.DatabaseResultMessage;
import model.serveur.connector.sqlQuery.RoleResultatSQL;
import model.serveur.database.PortResultatSQL;

public class ResultatSQL extends AttachmentFourni {

	public ResultatSQL(PortComposantCompositeFourni portCompo, RoleCompositeRequis role) {
		super(portCompo, role);
		this.portCompo.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortResultatSQL) {
			if (object instanceof DatabaseResultMessage) {
				((RoleResultatSQL) this.role).receive((DatabaseResultMessage) object);
			}
		}
	}

}
