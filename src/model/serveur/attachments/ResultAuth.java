package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.core.ResponseMessage;
import model.serveur.connector.clearanceRequest.RoleResultsAuth;
import model.serveur.connexionManager.PortResultsAuth;

public class ResultAuth extends AttachmentRequis {

	public ResultAuth(PortComposantCompositeRequis portCompo, RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleResultsAuth) {
			if (object instanceof ResponseMessage) {
				((PortResultsAuth) this.portCompo).receive((ResponseMessage) object);
			}
		}
	}

}
