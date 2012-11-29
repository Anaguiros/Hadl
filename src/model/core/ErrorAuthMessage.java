package model.core;

public class ErrorAuthMessage extends ResponseMessage {

	private String error;
	
	public ErrorAuthMessage(String error){
		this.contenu = DEFAULT_CONTENT;
		this.error = error;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		return "ErrorAuthMessage [error=" + error + ", contenu=" + contenu
				+ "]";
	}
}
