package metaModel.composant.composite;

public class PortComposantCompositeFourni extends PortComposantComposite {

	ServiceCompositeFourni service;
	
	public PortComposantCompositeFourni(String name, ServiceCompositeFourni service){
		this.name = name;
		this.service = service;
		
		System.out.println("Port Component Composite Provided Creation : "+name);
	}
	
	public void send(Object object){
		if (this.countObservers() == 0) {
			System.out.println(" x | Arrêt de la propagation de l'objet : aucun attachement sur " + this.getClass().getSimpleName());
		}
		this.setChanged();
		this.notifyObservers(object);
	}
}
