package model.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.client.PortEnvoiClient;
import model.connecteur.RoleEnvoiClient;

public class ReceptionServeur extends AttachmentRequis {

	public ReceptionServeur(PortComposantCompositeRequis portCompo,
			RoleCompositeFourni role) {
		super(portCompo, role);
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o, Object obj){
		String message = (String) obj;
		if(o instanceof PortEnvoiClient){
			System.out.println("Attachment ReceptionServeur : "+message);
			this.getPortCompo().getService();
		}
		else if (o instanceof RoleEnvoiClient){
			
		}
	}
}
