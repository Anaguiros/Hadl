package model.core;

public class DatabaseResultMessage extends Message {

	private String result;
	
	public DatabaseResultMessage(String result){
		this.contenu = DEFAULT_CONTENT;
		this.result = result;
	}

	public String getResult() {
		return result;
	}
}
