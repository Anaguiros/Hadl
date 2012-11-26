package model.core;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.configuration.PortConfigRequis;
import metaModel.core.BindingRequis;
import model.serveur.ConnexionComposantServeur;
import model.serveur.PortConnexionConfigServeur;

public class BindServeur extends BindingRequis implements Observer {

	public BindServeur(PortConfigRequis portConfig,
			PortComposantCompositeRequis portCompo) {
		super(portConfig, portCompo);
		
		this.getPortCompo().addObserver(this);
		this.getPortConfig().addObserver(this);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof PortConnexionConfigServeur) {
			((ConnexionComposantServeur) this.getPortConfig()).receive(this, object);
		}
		else if (o instanceof ConnexionComposantServeur){
			((PortConnexionConfigServeur) this.getPortCompo()).receive(this, object);
		}
	}

}
