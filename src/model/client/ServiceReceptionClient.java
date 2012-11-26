package model.client;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceReceptionClient extends ServiceCompositeRequis implements Observer {
	
	private PortReceptionClient portReceptionClient;

	public ServiceReceptionClient(String name){
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portReceptionClient = new PortReceptionClient(portName, this);
		this.portReceptionClient.addObserver(this);
		
		this.addPort(portName, portReceptionClient);
	}

	public PortReceptionClient getPortReceptionClient() {
		return portReceptionClient;
	}
	
	public void update(Observable o, Object object) {
		if (o instanceof PortReceptionClient) {
			this.setChanged();
			this.notifyObservers(object);
		}
	}
	
}
