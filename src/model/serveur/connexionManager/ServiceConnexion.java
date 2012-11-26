package model.serveur.connexionManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexion extends ServiceCompositeRequis implements Observer {
	
	private PortConnexion portConnexion;
	
	public ServiceConnexion(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portConnexion = new PortConnexion(portName, this);
		this.portConnexion.addObserver(this);
		this.addPort(portName, portConnexion);
	}

	public PortConnexion getPortConnexion() {
		return portConnexion;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortConnexion) {
			this.setChanged();
			this.notifyObservers(object);
		}
	}

}
