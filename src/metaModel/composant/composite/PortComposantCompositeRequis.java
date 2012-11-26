package metaModel.composant.composite;

public class PortComposantCompositeRequis extends PortComposantComposite {

	ServiceCompositeRequis service;
	
	public PortComposantCompositeRequis(String name, ServiceCompositeRequis service){
		this.service = service;
		this.name = name;
		
		System.out.println("Port Component Composite Required Creation : "+name);
	}
	
	
}
