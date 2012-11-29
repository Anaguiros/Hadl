package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.core.DatabaseQueryMessage;
import model.serveur.connector.sqlQuery.RoleRequeteSQL;
import model.serveur.database.PortRequeteSQL;

public class RequeteSQL extends AttachmentRequis {

	public RequeteSQL(PortComposantCompositeRequis portCompo, RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleRequeteSQL) {
			if (object instanceof DatabaseQueryMessage) {
				((PortRequeteSQL) this.portCompo).receive((DatabaseQueryMessage) object);
			}
		}
	}

}
