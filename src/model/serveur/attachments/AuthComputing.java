package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.core.AuthMessage;
import model.serveur.connector.clearanceRequest.RoleAuthComputing;
import model.serveur.securityManager.PortAuthComputing;

public class AuthComputing extends AttachmentRequis {

	public AuthComputing(PortComposantCompositeRequis portCompo, RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof RoleAuthComputing) {
			if (object instanceof AuthMessage) {
				((PortAuthComputing) this.portCompo).receive((AuthMessage) object);
			}
		}
	}

}
