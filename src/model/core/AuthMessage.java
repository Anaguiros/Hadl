package model.core;

public class AuthMessage extends Message {

	private String login, pass;
	
	public AuthMessage(String login, String password){
		this.contenu = DEFAULT_CONTENT;
		this.login = login;
		this.pass = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public String toString() {
		return "AuthMessage [login=" + login + ", pass=" + pass + ", contenu="
				+ contenu + "]";
	}
	
	
}
