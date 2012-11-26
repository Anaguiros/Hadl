package model.serveur.connector.clearanceRequest;

import metaModel.connecteur.composite.RoleCompositeRequis;

public class RoleRequeteAuth extends RoleCompositeRequis {

	public RoleRequeteAuth(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void receive(Object object) {
		// TODO Auto-generated method stub
		System.out.println("ClearanceRequest Role Requete Auth : " + object);
		this.setChanged();
		this.notifyObservers(object);
	}

}
