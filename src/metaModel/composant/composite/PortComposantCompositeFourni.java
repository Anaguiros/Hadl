package metaModel.composant.composite;


public class PortComposantCompositeFourni extends PortComposantComposite {

	ServiceCompositeFourni service;
	
	/**
	 * Constructeur de Port Composant Composite Fourni.
	 * @param name
	 * @param service
	 */
	public PortComposantCompositeFourni(String name, ServiceCompositeFourni service){
		this.name = name;
		this.service = service;
		
		System.out.println("Port Component Composite Provided Creation : "+name);
	}
	
}
