package model.connecteur;

import metaModel.connecteur.composite.RoleCompositeFourni;

public class RoleReceptionServeur extends RoleCompositeFourni {

	private RPC rpc;
	
	public RoleReceptionServeur(String name, RPC rpc) {
		super(name);
		this.rpc = rpc;
	}

	public RPC getRpc() {
		return rpc;
	}

}
