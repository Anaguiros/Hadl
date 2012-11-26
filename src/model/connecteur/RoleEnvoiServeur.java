package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiServeur extends RoleCompositeRequis {

	private RPC rpc;
	
	public RoleEnvoiServeur(String name, RPC rpc) {
		super(name);
		this.rpc = rpc;
	}

	public RPC getRpc() {
		return rpc;
	}

}
