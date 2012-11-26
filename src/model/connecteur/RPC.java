package model.connecteur;

import metaModel.connecteur.composite.ConnecteurComposite;

public class RPC extends ConnecteurComposite {

	private RoleEnvoiClient roleEnvoiClient;
	private RoleEnvoiServeur roleEnvoiServeur;
	private RoleReceptionClient roleReceptionClient;
	private RoleReceptionServeur roleReceptionServeur;
	
	public RPC(String name) {
		super(name);
		
		this.roleEnvoiClient = new RoleEnvoiClient("RoleEnvoiClient", this);
		this.roleEnvoiServeur = new RoleEnvoiServeur("RoleEnvoiServeur", this);
		this.roleReceptionClient = new RoleReceptionClient("RoleReceptionClient", this);
		this.roleReceptionServeur = new RoleReceptionServeur("RoleReceptionServeur", this);
		
		this.addInterfaceConnecteurComposite(roleEnvoiClient);
		this.addInterfaceConnecteurComposite(roleReceptionClient);
		this.addInterfaceConnecteurComposite(roleEnvoiServeur);
		this.addInterfaceConnecteurComposite(roleReceptionServeur);
	}

	public RoleEnvoiClient getRoleEnvoiClient() {
		return roleEnvoiClient;
	}

	public RoleEnvoiServeur getRoleEnvoiServeur() {
		return roleEnvoiServeur;
	}

	public RoleReceptionClient getRoleReceptionClient() {
		return roleReceptionClient;
	}

	public RoleReceptionServeur getRoleReceptionServeur() {
		return roleReceptionServeur;
	}
	

}
