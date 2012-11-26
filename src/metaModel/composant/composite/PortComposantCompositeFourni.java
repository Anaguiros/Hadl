package metaModel.composant.composite;

public class PortComposantCompositeFourni extends PortComposantComposite {

	ServiceCompositeFourni service;
	
	public PortComposantCompositeFourni(String name, ServiceCompositeFourni service){
		this.name = name;
		this.service = service;
		
		System.out.println("Port Component Composite Provided Creation : "+name);
	}
	
	public void sendMessage(String msg){
		setChanged();
		notifyObservers(msg);
	}
}
