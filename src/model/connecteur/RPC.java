package model.connecteur;

import metaModel.connecteur.composite.ConnecteurComposite;

public class RPC extends ConnecteurComposite {

	private RoleEnvoiClient roleEnvoiClient;
	private RoleEnvoiServeur roleEnvoiServeur;
	private RoleReceptionClient roleReceptionClient;
	private RoleReceptionServeur roleReceptionServeur;
	
	public RPC(String name) {
		super(name);
	}

	public RoleEnvoiClient getRoleEnvoiClient() {
		return roleEnvoiClient;
	}

	public void setRoleEnvoiClient(RoleEnvoiClient roleEnvoiClient) {
		this.roleEnvoiClient = roleEnvoiClient;
	}

	public RoleEnvoiServeur getRoleEnvoiServeur() {
		return roleEnvoiServeur;
	}

	public void setRoleEnvoiServeur(RoleEnvoiServeur roleEnvoiServeur) {
		this.roleEnvoiServeur = roleEnvoiServeur;
	}

	public RoleReceptionClient getRoleReceptionClient() {
		return roleReceptionClient;
	}

	public void setRoleReceptionClient(RoleReceptionClient roleReceptionClient) {
		this.roleReceptionClient = roleReceptionClient;
	}

	public RoleReceptionServeur getRoleReceptionServeur() {
		return roleReceptionServeur;
	}

	public void setRoleReceptionServeur(RoleReceptionServeur roleReceptionServeur) {
		this.roleReceptionServeur = roleReceptionServeur;
	}

}
