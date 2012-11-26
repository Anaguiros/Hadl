package model.serveur.connector.clearanceRequest;

import metaModel.connecteur.composite.ConnecteurComposite;

public class ClearanceRequest extends ConnecteurComposite {

	private RoleRequeteAuth roleRequeteAuth;
	private RoleResultsAuth roleResultsAuth;
	private RoleAuthComputing roleAuthComputing;
	private RoleAuthResults roleAuthResults;
	
	public ClearanceRequest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.roleAuthComputing = new RoleAuthComputing("RoleAuthComputing");
		this.roleAuthResults = new RoleAuthResults("RoleAuthResults");
		this.roleRequeteAuth = new RoleRequeteAuth("RoleRequeteAuth");
		this.roleResultsAuth = new RoleResultsAuth("RoleResultsAuth");
		
		this.addInterfaceConnecteurComposite(roleAuthComputing);
		this.addInterfaceConnecteurComposite(roleAuthResults);
		this.addInterfaceConnecteurComposite(roleRequeteAuth);
		this.addInterfaceConnecteurComposite(roleResultsAuth);
	}
	
	public void glue(){
		System.out.println("\tLink RoleRequeteAuth <-> RoleAuthComputing");
		this.roleRequeteAuth.addObserver(this.roleAuthComputing);
		System.out.println("\tLink RoleAuthResults <-> RoleResultsAuth");
		this.roleAuthResults.addObserver(this.roleResultsAuth);
	}

	public RoleRequeteAuth getRoleRequeteAuth() {
		return roleRequeteAuth;
	}

	public RoleResultsAuth getRoleResultsAuth() {
		return roleResultsAuth;
	}

	public RoleAuthComputing getRoleAuthComputing() {
		return roleAuthComputing;
	}

	public RoleAuthResults getRoleAuthResults() {
		return roleAuthResults;
	}

}
