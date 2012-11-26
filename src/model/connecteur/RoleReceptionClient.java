package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionClient extends RoleCompositeFourni {

	private RPC rpc;
	
	public RoleReceptionClient(String name, RPC rpc) {
		super(name);
		this.rpc = rpc;
	}

	public RPC getRpc() {
		return rpc;
	}

}
