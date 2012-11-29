package model.core;

public class DatabaseResultMessage extends ResponseMessage {

	private String result;
	
	public DatabaseResultMessage(String result){
		this.contenu = DEFAULT_CONTENT;
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "DatabaseResultMessage [result=" + result + ", contenu="
				+ contenu + "]";
	}
}
