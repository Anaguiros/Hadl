package model.connecteur;

import metaModel.connecteur.composite.ConnecteurComposite;

public class RPC extends ConnecteurComposite {

	private RoleEnvoiClient roleEnvoiClient;
	private RoleEnvoiServeur roleEnvoiServeur;
	private RoleReceptionClient roleReceptionClient;
	private RoleReceptionServeur roleReceptionServeur;
	
	public RPC(String name) {
		super(name);
		
		this.roleEnvoiClient = new RoleEnvoiClient("RoleEnvoiClient");
		this.roleEnvoiServeur = new RoleEnvoiServeur("RoleEnvoiServeur");
		this.roleReceptionClient = new RoleReceptionClient("RoleReceptionClient");
		this.roleReceptionServeur = new RoleReceptionServeur("RoleReceptionServeur");
		
		this.addInterfaceConnecteurComposite(roleEnvoiClient);
		this.addInterfaceConnecteurComposite(roleReceptionClient);
		this.addInterfaceConnecteurComposite(roleEnvoiServeur);
		this.addInterfaceConnecteurComposite(roleReceptionServeur);
	}
	
	public void glue() {
		this.roleEnvoiClient.addObserver(this.roleReceptionServeur);
		this.roleEnvoiServeur.addObserver(this.roleReceptionClient);
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
