package model.serveur.attachments;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.core.DatabaseResultMessage;
import model.serveur.connector.sqlQuery.RoleResultat;
import model.serveur.connexionManager.PortResultat;

public class Resultat extends AttachmentRequis implements Observer {

	public Resultat(PortComposantCompositeRequis portCompo, RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}
	
	public void update(Observable o, Object object) {
		if (o instanceof RoleResultat) {
			((PortResultat) this.portCompo).receive((DatabaseResultMessage) object);
		}
	}

}
