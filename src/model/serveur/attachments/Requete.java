package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.core.DatabaseQueryMessage;
import model.serveur.connector.sqlQuery.RoleRequete;
import model.serveur.connexionManager.PortRequete;

public class Requete extends AttachmentFourni {

	public Requete(PortComposantCompositeFourni portCompo, RoleCompositeRequis role) {
		super(portCompo, role);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortRequete) {
			((RoleRequete) this.role).receive((DatabaseQueryMessage) object);
		}
	}

	
}
