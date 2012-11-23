package metaModel.core;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.configuration.PortConfigFourni;

public class BindingFourni {

	PortConfigFourni portConfig;
	PortComposantCompositeFourni portCompo;
	
	public BindingFourni(PortConfigFourni portConfig, PortComposantCompositeFourni portCompo){
		this.portConfig = portConfig;
		this.portCompo = portCompo;
		
		System.out.println("Binding Provided Creation : "+portCompo.getName()+" & "+portConfig.getName());
	}

	public PortConfigFourni getPortConfig() {
		return portConfig;
	}

	public PortComposantCompositeFourni getPortCompo() {
		return portCompo;
	}

}
