package model.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.client.PortReceptionClient;
import model.connecteur.RoleReceptionClient;

public class ReceptionClient extends AttachmentRequis {

	public ReceptionClient(PortComposantCompositeRequis portCompo,
			RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}
	
	public void update(Observable o, Object object) {
		if(o instanceof RoleReceptionClient){
			if(object instanceof AuthResponseMessage){
				((PortReceptionClient) this.portCompo).receive(object);
			}
		}
	}

}
