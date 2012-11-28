package metaModel.core;

import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;

public abstract class AttachmentFourni implements Observer {

	protected PortComposantCompositeFourni portCompo;
	protected RoleCompositeRequis role;
	
	/**
	 * Constructeur d'un attachment fourni entre un {@link PortComposantCompositeFourni} et un {@link RoleCompositeRequis}.
	 * @param portCompo
	 * @param role
	 */
	public AttachmentFourni(PortComposantCompositeFourni portCompo, RoleCompositeRequis role){
		this.portCompo = portCompo;
		this.role = role;
		
		System.out.println("Attachment Provided Creation : "+portCompo.getName()+" & "+role.getName());
	}

	public PortComposantCompositeFourni getPortCompo() {
		return portCompo;
	}

	public RoleCompositeRequis getRole() {
		return role;
	}

}
