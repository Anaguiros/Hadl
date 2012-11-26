package model.serveur.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.serveur.connector.clearanceRequest.RoleRequeteAuth;
import model.serveur.connexionManager.PortRequeteAuth;

public class RequeteAuth extends AttachmentFourni {

	public RequeteAuth(PortRequeteAuth portCompo,
			RoleRequeteAuth role) {
		super(portCompo, role);
		// TODO Auto-generated constructor stub
	}
	
	public void update(Observable observable, Object object){
		if(object instanceof RoleRequeteAuth){
			((RoleRequeteAuth) this.role).receive(object);
		}
	}

}
