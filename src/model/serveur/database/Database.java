package model.serveur.database;

import metaModel.composant.composite.ComposantComposite;

public class Database extends ComposantComposite {

	public Database(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.addInterface("ServiceRequeteSQL", new ServiceRequeteSQL("ServiceRequeteSQL"));
		this.addInterface("ServiceResultatSQL", new ServiceResultatSQL("ServiceResultatSQL"));
		this.addInterface("ServiceRequeteSecurity", new ServiceRequeteSecurity("ServiceRequeteSecurity"));
		this.addInterface("ServiceResultatSecurity", new ServiceResultatSecurity("ServiceResultatSecurity"));
	}


}
