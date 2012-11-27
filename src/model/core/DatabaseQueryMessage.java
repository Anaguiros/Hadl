package model.core;

public class DatabaseQueryMessage extends Message {

	private String query;
	
	public DatabaseQueryMessage(String query){
		this.contenu = DEFAULT_CONTENT;
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "DatabaseQueryMessage [query=" + query + ", contenu=" + contenu
				+ "]";
	}
}
