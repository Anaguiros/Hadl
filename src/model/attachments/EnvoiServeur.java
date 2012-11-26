package model.attachments;

import java.util.Observable;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;
import model.connecteur.RoleEnvoiServeur;
import model.serveur.PortEnvoiServeur;

public class EnvoiServeur extends AttachmentFourni {

	public EnvoiServeur(PortComposantCompositeFourni portCompo,
			RoleCompositeRequis role) {
		super(portCompo, role);
		this.portCompo.addObserver(this);
	}

	public void update(Observable o, Object object){
		if(o instanceof PortEnvoiServeur){
			((RoleEnvoiServeur) this.role).receive(object);
		}
	}
}
