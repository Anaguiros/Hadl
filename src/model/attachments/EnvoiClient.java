package model.attachments;

import java.util.Observable;

import metaModel.core.AttachmentFourni;
import model.client.PortEnvoiClient;
import model.connecteur.RoleEnvoiClient;

public class EnvoiClient extends AttachmentFourni {
	
	public EnvoiClient(PortEnvoiClient portCompo,
			RoleEnvoiClient role) {
		
		super(portCompo, role);
	}
	
	public void update(Observable o, Object object){
		if(o instanceof PortEnvoiClient){
			System.out.println("Attachment EnvoieClient : " + object);
			((RoleEnvoiClient) this.role).receive(object);
		}
	}

	
}
