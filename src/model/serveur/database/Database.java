package model.serveur.database;

import java.util.Observable;
import java.util.Observer;

import metaModel.composant.composite.ComposantComposite;
import model.core.DatabaseQueryMessage;
import model.core.DatabaseResultMessage;

public class Database extends ComposantComposite implements Observer {

	private ServiceRequeteSQL serviceRequeteSQL;
	private ServiceResultatSQL serviceResultatSQL;
	private ServiceRequeteSecurity serviceRequeteSecurity;
	private ServiceResultatSecurity serviceResultatSecurity;
	
	public Database(String name) {
		super(name);
		
		this.serviceRequeteSQL = new ServiceRequeteSQL("ServiceRequeteSQL");
		this.serviceResultatSQL = new ServiceResultatSQL("ServiceResultatSQL");
		this.serviceRequeteSecurity = new ServiceRequeteSecurity("ServiceRequeteSecurity");
		this.serviceResultatSecurity = new ServiceResultatSecurity("ServiceResultatSecurity");
		
		this.serviceRequeteSQL.addObserver(this);
		this.serviceRequeteSecurity.addObserver(this);
		
		this.addInterface("ServiceRequeteSQL", this.serviceRequeteSQL);
		this.addInterface("ServiceResultatSQL", this.serviceResultatSQL);
		this.addInterface("ServiceRequeteSecurity", this.serviceRequeteSecurity);
		this.addInterface("ServiceResultatSecurity", this.serviceResultatSecurity);
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof ServiceRequeteSQL) {
			if (object instanceof DatabaseQueryMessage) {
				DatabaseResultMessage databaseResultMessage = this.process((DatabaseQueryMessage) object);
				this.serviceResultatSQL.send(databaseResultMessage);
			}
		}
		else if (o instanceof ServiceRequeteSecurity) {
			if (object instanceof DatabaseQueryMessage) {
				DatabaseResultMessage databaseResultMessage = this.process((DatabaseQueryMessage) object);
				this.serviceResultatSecurity.send(databaseResultMessage);
			}
		}
	}

	public DatabaseResultMessage process(DatabaseQueryMessage databaseQueryMessage) {
		DatabaseResultMessage databaseResultMessage = new DatabaseResultMessage("OK");
		System.out.println("Database is processing !");
		return databaseResultMessage;
	}

}
