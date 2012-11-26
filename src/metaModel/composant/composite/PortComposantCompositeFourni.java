package metaModel.composant.composite;

import metaModel.core.AttachmentFourni;

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
	
	/**
	 * Méthode permettant d'envoyer un message vers un attachment. L'{@link AttachmentFourni} connait le port, mais pas l'inverse. On a donc besoin de la mise ne place d'un patter Observer.
	 * @param object
	 */
	public void send(Object object){
		if (this.countObservers() == 0) {
			System.out.println(" x | Arrêt de la propagation de l'objet : aucun attachement sur " + this.getClass().getSimpleName());
		}
		this.setChanged();
		this.notifyObservers(object);
	}
}
