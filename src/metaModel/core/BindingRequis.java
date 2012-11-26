package metaModel.core;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.configuration.PortConfigRequis;

public class BindingRequis {

	protected PortConfigRequis portConfig;
	protected PortComposantCompositeRequis portCompo;
	
	public BindingRequis(PortConfigRequis portConfig, PortComposantCompositeRequis portCompo){
		this.portConfig = portConfig;
		this.portCompo = portCompo;
		
		System.out.println("Binding Required Creation : "+portCompo.getName()+" & "+portConfig.getName());
	}

	public PortConfigRequis getPortConfig() {
		return portConfig;
	}

	public PortComposantCompositeRequis getPortCompo() {
		return portCompo;
	}
	
}
