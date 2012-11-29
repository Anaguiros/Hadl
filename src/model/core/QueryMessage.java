package model.core;

public class QueryMessage extends Message {

	private String login, pass, query;
	
	public QueryMessage(String login, String password, String query){
		this.contenu = DEFAULT_CONTENT;
		this.login = login;
		this.pass = password;
		this.query = query;
	}

	public String getLogin() {
		return login;
	}

	public String getPass() {
		return pass;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "ConnexionMessage [login=" + login + ", pass=" + pass
				+ ", query=" + query + ", contenu=" + contenu + "]";
	}
	
	
}
