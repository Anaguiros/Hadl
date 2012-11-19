package model.core;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.configuration.PortConfigRequis;
import metaModel.core.BindingRequis;

public class BindConnexionServeur extends BindingRequis{

	public BindConnexionServeur(PortConfigRequis portConfig,
			PortComposantCompositeRequis portCompo) {
		super(portConfig, portCompo);
	}

}
