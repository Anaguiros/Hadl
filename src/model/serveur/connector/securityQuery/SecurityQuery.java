package model.serveur.connector.securityQuery;

import metaModel.connecteur.composite.ConnecteurComposite;

public class SecurityQuery extends ConnecteurComposite {

	public SecurityQuery(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.addInterfaceConnecteurComposite(new RoleResultatSecurity("RoleResultatSecurity"));
		this.addInterfaceConnecteurComposite(new RoleRequeteSecurity("RoleRequeteSecurity"));
		this.addInterfaceConnecteurComposite(new RoleSecurityResults("RoleSecurityResults"));
		this.addInterfaceConnecteurComposite(new RoleSecurityComputing("RoleSecurityComputing"));
	}

}
