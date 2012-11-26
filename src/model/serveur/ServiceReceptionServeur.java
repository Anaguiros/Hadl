package model.serveur;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionServeur extends ServiceCompositeRequis implements Observer {

	private PortReceptionServeur portReception;
	
	public ServiceReceptionServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portReception = new PortReceptionServeur(portName, this);
		this.portReception.addObserver(this);
		this.addPort(portName, portReception);
	}

	public PortReceptionServeur getPortReception() {
		return portReception;
	}

	public void update(Observable o, Object object) {
		if (o instanceof PortReceptionServeur) {
			this.setChanged();
			this.notifyObservers(object);
		}
	}
	
}
