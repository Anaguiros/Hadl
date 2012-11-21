package model.serveur.connexionManager;

import metaModel.composant.composite.ServiceCompositeRequis;

public class ServiceResultat extends ServiceCompositeRequis {

	private PortResultat portResultat;
	
	public ServiceResultat(String name, PortResultat portResultat) {
		super(name);
		this.portResultat = portResultat;
	}

	public PortResultat getPortResultat() {
		return this.portResultat;
	}
}
