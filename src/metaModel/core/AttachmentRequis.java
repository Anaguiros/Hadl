package metaModel.core;

import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;

public abstract class AttachmentRequis implements Observer {

	protected PortComposantCompositeRequis portCompo;
	protected RoleCompositeFourni role;
	
	/**
	 * Constructeur d'un Attachment Requis, entre un {@link PortComposantCompositeRequis} et un {@link RoleCompositeFourni}.
	 * @param portCompo
	 * @param role
	 */
	public  AttachmentRequis(PortComposantCompositeRequis portCompo, RoleCompositeFourni role){
		this.portCompo = portCompo;
		this.role = role;
		
		System.out.println("Attachment Required Creation : "+portCompo.getName()+" & "+role.getName());
	}

	public PortComposantCompositeRequis getPortCompo() {
		return portCompo;
	}

	public RoleCompositeFourni getRole() {
		return role;
	}

}
