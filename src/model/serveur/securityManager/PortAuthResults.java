package model.serveur.securityManager;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.ServiceCompositeFourni;
import model.core.ResponseMessage;

public class PortAuthResults extends PortComposantCompositeFourni {

	public PortAuthResults(String name, ServiceCompositeFourni service) {
		super(name, service);
	}
	
	public void send(ResponseMessage responseMessage) {
		if (this.countObservers() == 0) {
			System.out.println(" x | " + this.getClass().getSimpleName() + "     | Arret de la propagation de l'objet : aucun attachement");
		}
		this.setChanged();
		this.notifyObservers(responseMessage);
	}

}
