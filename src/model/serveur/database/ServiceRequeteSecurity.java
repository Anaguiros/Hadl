package model.serveur.database;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseQueryMessage;

public class ServiceRequeteSecurity extends ServiceCompositeRequis implements Observer {

	private PortRequeteSecurity portRequeteSecurity;
	
	public ServiceRequeteSecurity(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portRequeteSecurity = new PortRequeteSecurity(portName, this);
		this.portRequeteSecurity.addObserver(this);
		this.addPort(portName, portRequeteSecurity);
	}

	public PortRequeteSecurity getPortRequeteSecurity() {
		return portRequeteSecurity;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortRequeteSecurity) {
			if (object instanceof DatabaseQueryMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}

}
