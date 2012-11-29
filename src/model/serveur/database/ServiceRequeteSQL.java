package model.serveur.database;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ServiceCompositeRequis;
import model.core.DatabaseQueryMessage;

public class ServiceRequeteSQL extends ServiceCompositeRequis implements Observer {

	private PortRequeteSQL portRequeteSQL;
	
	public ServiceRequeteSQL(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		String portName = name.replace("Service", "Port");
		
		this.portRequeteSQL = new PortRequeteSQL(portName, this);
		this.portRequeteSQL.addObserver(this);
		this.addPort(portName, portRequeteSQL);
	}

	public PortRequeteSQL getPortRequeteSQL() {
		return portRequeteSQL;
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortResultatSQL) {
			if (object instanceof DatabaseQueryMessage) {
				this.setChanged();
				this.notifyObservers(object);
			}
		}
	}

}
