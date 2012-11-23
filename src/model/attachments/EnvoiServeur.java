package model.attachments;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import metaModel.core.AttachmentFourni;

public class EnvoiServeur extends AttachmentFourni {

	public EnvoiServeur(PortComposantCompositeFourni portCompo,
			RoleCompositeRequis role) {
		super(portCompo, role);
	}

}
