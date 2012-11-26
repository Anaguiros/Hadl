package model.serveur;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceConnexionConfigServeur extends ServiceCompositeRequis implements Observer {

	private PortConnexionConfigServeur portConnexionConfig;
	
	public ServiceConnexionConfigServeur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portConnexionConfig = new PortConnexionConfigServeur(portName, this);
		this.portConnexionConfig.addObserver(this);
		this.addPort(portName, portConnexionConfig);
	}

	public PortConnexionConfigServeur getPortConnexionConfig() {
		return portConnexionConfig;
	}
	
	public void send(Object object) {
		this.portConnexionConfig.send(object);
	}

	public void update(Observable o, Object object) {
		if (o instanceof PortConnexionConfigServeur) {
			this.setChanged();
			this.notifyObservers(object);
		}
	}
	
}
