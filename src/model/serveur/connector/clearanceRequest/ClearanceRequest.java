package model.serveur.connector.clearanceRequest;

import metaModel.connecteur.composite.ConnecteurComposite;

public class ClearanceRequest extends ConnecteurComposite {

	public ClearanceRequest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.addInterfaceConnecteurComposite(new RoleRequeteAuth("RoleRequeteAuth"));
		this.addInterfaceConnecteurComposite(new RoleResultsAuth("RoleResultsAuth"));
		this.addInterfaceConnecteurComposite(new RoleAuthResults("RoleAuthResults"));
		this.addInterfaceConnecteurComposite(new RoleAuthComputing("RoleAuthComputing"));
	}

}
