package model.serveur.connector.sqlQuery;

import metaModel.connecteur.composite.ConnecteurComposite;

public class SQLQuery extends ConnecteurComposite {

	public SQLQuery(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.addInterfaceConnecteurComposite(new RoleResultat("RoleResultat"));
		this.addInterfaceConnecteurComposite(new RoleRequete("RoleRequete"));
		this.addInterfaceConnecteurComposite(new RoleRequeteSQL("RoleRequeteSQL"));
		this.addInterfaceConnecteurComposite(new RoleResultatSQL("RoleResultatSQL"));
	}

}
