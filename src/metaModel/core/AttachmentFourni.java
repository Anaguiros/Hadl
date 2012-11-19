package metaModel.core;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;

public class AttachmentFourni {

	PortComposantCompositeFourni portCompo;
	RoleCompositeRequis role;
	
	public AttachmentFourni(PortComposantCompositeFourni portCompo, RoleCompositeRequis role){
		this.portCompo = portCompo;
		this.role = role;
	}

	public PortComposantCompositeFourni getPortCompo() {
		return portCompo;
	}

	public RoleCompositeRequis getRole() {
		return role;
	}
	
	
	
}
