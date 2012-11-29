package model.serveur.connexionManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.ResponseMessage;

public class ServiceResultsAuth extends ServiceCompositeRequis implements Observer {
	
	private PortResultsAuth portResultsAuth;
	
	public ServiceResultsAuth(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portResultsAuth = new PortResultsAuth(portName, this);
		this.portResultsAuth.addObserver(this);
		this.addPort(portName, portResultsAuth);
	}

	public PortResultsAuth getPortResultsAuth() {
		return portResultsAuth;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortResultsAuth) {
			if (object instanceof ResponseMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
	
	

}
