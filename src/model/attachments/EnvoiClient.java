package model.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.client.PortEnvoiClient;
import model.connecteur.RoleEnvoiClient;

public class EnvoiClient extends AttachmentFourni {
	
	public EnvoiClient(PortEnvoiClient portCompo,
			RoleEnvoiClient role) {
		super(portCompo, role);
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o, Object obj){
		String message = (String) obj;
		if(o instanceof PortEnvoiClient){
			System.out.println(message);
		}
		else if (o instanceof RoleEnvoiClient){
			
		}
	}
	
}
