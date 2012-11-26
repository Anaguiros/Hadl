package model.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.ConnecteurComposite;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.client.PortEnvoiClient;
import model.connecteur.RPC;
import model.connecteur.RoleEnvoiClient;

public class EnvoiClient extends AttachmentFourni {
	
	private PortEnvoiClient portEnvoiClient;
	private RoleEnvoiClient roleEnvoiClient;
	
	public EnvoiClient(PortEnvoiClient portCompo,
			RoleEnvoiClient role, RPC connect) {
		
		super(portCompo, role);
		
		// TODO Auto-generated constructor stub
	}
	
	public void update(Observable o, Object obj){
		String message = (String) obj;
		if(o instanceof PortEnvoiClient){
			System.out.println("Attachment EnvoieClient : "+message);
			((RoleEnvoiClient)this.getRole()).getRpc().getRoleReceptionClient();
		}
		else if (o instanceof RoleEnvoiClient){
			
		}
	}

	
}
