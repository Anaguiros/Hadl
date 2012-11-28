package model.serveur.connexionManager;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseResultMessage;

public class ServiceResultat extends ServiceCompositeRequis implements Observer {
	
	private PortResultat portResultat;
	
	public ServiceResultat(String name) {
		super(name);
		String portName = name.replace("Service", "Port");
		
		this.portResultat = new PortResultat(portName, this);
		this.portResultat.addObserver(this);
		
		this.addPort(portName, portResultat);
	}

	public PortResultat getPortResultat() {
		return portResultat;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortResultat) {
			if (object instanceof DatabaseResultMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}
}
