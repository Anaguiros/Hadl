package model.serveur.database;

import java.util.HashMap;
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
	
	private HashMap<String, String> users;
	private HashMap<String, String> datas;
	
	public Database(String name) {
		super(name);
		
		this.users = new HashMap<String, String>();
		this.datas = new HashMap<String, String>();
		
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
			System.out.println("-> | " + this.getClass().getSimpleName() + "             | Reception from ConnexionManager : " + object);
			if (object instanceof DatabaseQueryMessage) {
				DatabaseResultMessage databaseResultMessage = this.process((DatabaseQueryMessage) object);
				System.out.println("<- | " + this.getClass().getSimpleName() + "             | Send to ConnexionManager : " + databaseResultMessage);
				this.serviceResultatSQL.send(databaseResultMessage);
			}
		}
		else if (o instanceof ServiceRequeteSecurity) {
			System.out.println("-> | " + this.getClass().getSimpleName() + "             | Reception from SecurityManager : " + object);
			if (object instanceof DatabaseQueryMessage) {
				DatabaseResultMessage databaseResultMessage = this.process((DatabaseQueryMessage) object);
				System.out.println("<- | " + this.getClass().getSimpleName() + "             | Send to SecurityManager : " + databaseResultMessage);
				this.serviceResultatSecurity.send(databaseResultMessage);
			}
		}
	}

	public DatabaseResultMessage process(DatabaseQueryMessage databaseQueryMessage) {
		DatabaseResultMessage databaseResultMessage = null;
		String query = databaseQueryMessage.getQuery();
		try {
			String[] bribes = query.split(" ");
			String key = bribes[1];
			String base = bribes[3];
			if (base.equals("users")) {
				if (this.users.containsKey(key)) {
					databaseResultMessage = new DatabaseResultMessage(this.users.get(key));
				}
				else {
					databaseResultMessage = new DatabaseResultMessage("invalid user");
				}
			}
			else if (base.equals("datas")) {
				if (key.equals("*")) {
					String result = "";
					for (String keyData : this.datas.keySet()) {
						result += "[" + keyData + ":" + this.datas.get(keyData) + "]";
					}
					databaseResultMessage = new DatabaseResultMessage(result);
				}
				else {
					databaseResultMessage = new DatabaseResultMessage(this.datas.get(key));
				}
			}
		} catch (Exception ex) {
			databaseResultMessage = new DatabaseResultMessage(ex.getLocalizedMessage());
		}

		System.out.println(" o | " + this.getClass().getSimpleName() + "             | \tExecution de la requete : " + query);
		return databaseResultMessage;
	}
	
	public void addUser(String login, String password) {
		this.users.put(login,  password);
	}
	
	public void addData(String key, String value) {
		this.datas.put(key, value);
	}

}
