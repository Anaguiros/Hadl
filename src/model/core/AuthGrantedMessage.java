package model.core;

public class AuthGrantedMessage extends ResponseMessage {

	private String credentials;
	
	public AuthGrantedMessage(String credentials){
		this.contenu = DEFAULT_CONTENT;
		this.credentials = credentials;
	}

	public String getCredentials() {
		return credentials;
	}

	@Override
	public String toString() {
		return "AuthGrantedMessage [credentials=" + credentials + ", contenu="
				+ contenu + "]";
	}
}
