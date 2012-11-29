package model.serveur;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseResultMessage;
import model.core.ErrorAuthMessage;

public class ServiceConnexionConfigServeur extends ServiceCompositeRequis implements Observer {

	private PortConnexionConfigServeur portConnexionConfig;
	
	public ServiceConnexionConfigServeur(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portConnexionConfig = new PortConnexionConfigServeur(portName, this);
		this.portConnexionConfig.addObserver(this);
		this.addPort(portName, portConnexionConfig);
	}

	public PortConnexionConfigServeur getPortConnexionConfig() {
		return portConnexionConfig;
	}
	
	public void send(Object object) {
		this.portConnexionConfig.send(this, object);
	}

	public void update(Observable o, Object object) {
		if (o instanceof PortConnexionConfigServeur) {
			if (object instanceof DatabaseResultMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
			else if (object instanceof ErrorAuthMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
	
}
