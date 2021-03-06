package metaModel.composant.composite;

public class PortComposantCompositeRequis extends PortComposantComposite {

	private ServiceCompositeRequis service;
	
	/**
	 * Constructeur de Port Composant Composite Requis.
	 * @param name
	 * @param service
	 */
	public PortComposantCompositeRequis(String name, ServiceCompositeRequis service){
		this.service = service;
		this.name = name;
		
		System.out.println("Port Component Composite Required Creation : "+name);
	}

	public ServiceCompositeRequis getService() {
		return service;
	}
	
	
}
