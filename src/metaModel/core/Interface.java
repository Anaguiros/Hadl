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
	
}
