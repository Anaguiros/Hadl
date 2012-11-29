package model.serveur.connector.sqlQuery;

import metaModel.connecteur.composite.ConnecteurComposite;

public class SQLQuery extends ConnecteurComposite {

	private RoleResultat roleResultat;
	private RoleRequete roleRequete;
	private RoleRequeteSQL roleRequeteSQL;
	private RoleResultatSQL roleResultatSQL;
	
	public SQLQuery(String name) {
		super(name);
		
		this.roleResultat = new RoleResultat("RoleResultat");
		this.roleRequete = new RoleRequete("RoleRequete");
		this.roleRequeteSQL = new RoleRequeteSQL("RoleRequeteSQL");
		this.roleResultatSQL = new RoleResultatSQL("RoleResultatSQL");
		
		this.addInterfaceConnecteurComposite(roleResultat);
		this.addInterfaceConnecteurComposite(roleRequete);
		this.addInterfaceConnecteurComposite(roleRequeteSQL);
		this.addInterfaceConnecteurComposite(roleResultatSQL);
	}

	public void glue() {
		this.roleResultatSQL.addObserver(this.roleResultat);
		this.roleRequete.addObserver(this.roleRequeteSQL);
		
	}
}
