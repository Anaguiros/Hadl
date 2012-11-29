package model.serveur.connector.securityQuery;

import metaModel.connecteur.composite.ConnecteurComposite;

public class SecurityQuery extends ConnecteurComposite {

	private RoleResultatSecurity roleResultatSecurity;
	private RoleRequeteSecurity roleRequeteSecurity;
	private RoleSecurityResults roleSecurityResults;
	private RoleSecurityComputing roleSecurityComputing;
	
	public SecurityQuery(String name) {
		super(name);
		
		this.roleResultatSecurity = new RoleResultatSecurity("RoleResultatSecurity");
		this.roleRequeteSecurity = new RoleRequeteSecurity("RoleRequeteSecurity");
		this.roleSecurityResults = new RoleSecurityResults("RoleSecurityResults");
		this.roleSecurityComputing = new RoleSecurityComputing("RoleSecurityComputing");
		
		this.addInterfaceConnecteurComposite(this.roleResultatSecurity);
		this.addInterfaceConnecteurComposite(this.roleRequeteSecurity);
		this.addInterfaceConnecteurComposite(this.roleSecurityResults);
		this.addInterfaceConnecteurComposite(this.roleSecurityComputing);
	}

	public void glue() {
		this.roleResultatSecurity.addObserver(this.roleSecurityResults);
		this.roleSecurityComputing.addObserver(this.roleRequeteSecurity);
	}
}
