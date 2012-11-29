package model.serveur.securityManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.AuthMessage;

public class ServiceAuthComputing extends ServiceCompositeRequis implements Observer {

	private PortAuthComputing portAuthComputing;
	
	public ServiceAuthComputing(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portAuthComputing = new PortAuthComputing(portName, this);
		this.portAuthComputing.addObserver(this);
		this.addPort(portName, portAuthComputing);
	}

	public PortAuthComputing getPortAuthComputing() {
		return portAuthComputing;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortAuthComputing) {
			if (object instanceof AuthMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
	
	

}
