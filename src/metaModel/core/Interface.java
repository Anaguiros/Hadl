package metaModel.core;

public abstract class Interface {

	public enum Type {
		PRIVATE,
		PUBLIC
	}
	
	public enum Synchronisation {
		ASYNCHRONE,
		SYNCHRONE
	}
	
	protected Type type;
	protected Synchronisation synchronisation;
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
