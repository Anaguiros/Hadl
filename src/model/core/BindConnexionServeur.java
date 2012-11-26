package model.core;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.configuration.PortConfigRequis;
import metaModel.core.BindingRequis;
import model.serveur.PortConnexionServer;
import model.serveur.connexionManager.PortConnexion;

public class BindConnexionServeur extends BindingRequis implements Observer {

	public BindConnexionServeur(PortConfigRequis portConfig,
			PortComposantCompositeRequis portCompo) {
		super(portConfig, portCompo);
		this.portCompo.addObserver(this);
		this.portConfig.addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortConnexion) {
			((PortConnexionServer) this.getPortConfig()).receive(this, object);
		}
		else if (o instanceof PortConnexionServer){
			((PortConnexion) this.getPortCompo()).receive(this, object);
		}
	}

}
