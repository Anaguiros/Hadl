package metaModel.core;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.configuration.PortConfigRequis;

public class BindingRequis {

	PortConfigRequis portConfig;
	PortComposantCompositeRequis portCompo;
	
	public BindingRequis(PortConfigRequis portConfig, PortComposantCompositeRequis portCompo){
		this.portConfig = portConfig;
		this.portCompo = portCompo;
	}

	public PortConfigRequis getPortConfig() {
		return portConfig;
	}

	public PortComposantCompositeRequis getPortCompo() {
		return portCompo;
	}
	
}
