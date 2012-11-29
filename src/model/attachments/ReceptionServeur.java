package model.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.core.AttachmentRequis;
import model.connecteur.RoleReceptionServeur;
import model.core.QueryMessage;
import model.serveur.PortReceptionServeur;

public class ReceptionServeur extends AttachmentRequis {

	public ReceptionServeur(PortComposantCompositeRequis portCompo,
			RoleCompositeFourni role) {
		super(portCompo, role);
		this.role.addObserver(this);
	}

	public void update(Observable o, Object object){
		if(o instanceof RoleReceptionServeur){
			if(object instanceof QueryMessage){
				((PortReceptionServeur) this.portCompo).receive(object);
			}
		}
	}
}
