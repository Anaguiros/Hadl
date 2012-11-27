package model.attachments;

import java.util.Observable;

import metaModel.core.AttachmentFourni;
import model.client.PortEnvoiClient;
import model.connecteur.RoleEnvoiClient;
import model.core.AuthMessage;
import model.core.ConnexionMessage;

public class EnvoiClient extends AttachmentFourni {
	
	public EnvoiClient(PortEnvoiClient portCompo,
			RoleEnvoiClient role) {
		
		super(portCompo, role);
		this.portCompo.addObserver(this);
	}
	
	public void update(Observable o, Object object){
		if(o instanceof PortEnvoiClient){
			if(object instanceof ConnexionMessage){
				((RoleEnvoiClient) this.role).receive(object);
			}
		}
	}

	
}
