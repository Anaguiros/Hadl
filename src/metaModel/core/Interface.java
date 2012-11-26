package metaModel.core;

import java.util.Observable;

public abstract class Interface extends Observable{

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
