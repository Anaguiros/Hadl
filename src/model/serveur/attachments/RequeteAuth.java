package model.serveur.attachments;

import java.util.Observable;
import java.util.Observer;

import metaModel.core.AttachmentFourni;
import model.core.AuthMessage;
import model.serveur.connector.clearanceRequest.RoleRequeteAuth;
import model.serveur.connexionManager.PortRequeteAuth;

public class RequeteAuth extends AttachmentFourni implements Observer{
	
	public RequeteAuth(PortRequeteAuth portCompo,
			RoleRequeteAuth role) {
		super(portCompo, role);
		// TODO Auto-generated constructor stub
	}
	
	public void update(Observable observable, Object object){
		if(object instanceof PortRequeteAuth){
			((RoleRequeteAuth) this.role).receive((AuthMessage) object);
		}
	}

}
