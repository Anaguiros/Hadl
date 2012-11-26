package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleEnvoiClient extends RoleCompositeRequis {

	private RPC rpc;
	
	public RoleEnvoiClient(String name, RPC rpc) {
		super(name);
		this.rpc = rpc;
	}

	public RPC getRpc() {
		return rpc;
	}

}
