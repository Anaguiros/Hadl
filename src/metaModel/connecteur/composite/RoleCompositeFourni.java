package metaModel.connecteur.composite;

import java.util.Observable;
import java.util.Observer;

public class RoleCompositeFourni extends RoleComposite implements Observer {

	public RoleCompositeFourni(String name) {
		this.name = name;
		
		System.out.println("Role Connector Composite Provided Creation : "+name);
	}

	@Override
	public void update(Observable o, Object arg) {}
	
}
