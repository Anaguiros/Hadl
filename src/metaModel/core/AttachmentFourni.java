package metaModel.core;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;

public class AttachmentFourni implements Observer{

	protected PortComposantCompositeFourni portCompo;
	protected RoleCompositeRequis role;
	
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
