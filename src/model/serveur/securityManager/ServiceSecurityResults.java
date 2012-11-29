package model.serveur.securityManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseResultMessage;

public class ServiceSecurityResults extends ServiceCompositeRequis implements Observer {

	private PortSecurityResults portSecurityResults;
	
	public ServiceSecurityResults(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portSecurityResults = new PortSecurityResults(portName, this);
		this.portSecurityResults.addObserver(this);
		this.addPort(portName, portSecurityResults);
	}

	public PortSecurityResults getPortSecurityResults() {
		return portSecurityResults;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortSecurityResults) {
			if (object instanceof DatabaseResultMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}

}
