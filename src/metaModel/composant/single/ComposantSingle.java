package metaModel.composant.single;

import java.util.ArrayList;

import metaModel.composant.Composant;

public class ComposantSingle extends Composant {

	//Composition d'interfaces
	protected ArrayList<InterfaceComposantSingle> listInterfaces;
	
	public ComposantSingle(String name) {
		this.name = name;
		this.listInterfaces = new ArrayList<InterfaceComposantSingle>();
	}
	
	public void addInterfaceComposantSingle(InterfaceComposantSingle ics) {
		if (!this.listInterfaces.contains(ics)) {
			this.listInterfaces.add(ics);
		}
	}
	
	public void removeInterfaceComposantSingle(String name) {
		for (InterfaceComposantSingle ics : this.listInterfaces) {
			if (ics.getName().equals(name)) {
				this.listInterfaces.remove(ics);
				break;
			}
		}
	}
	
	public InterfaceComposantSingle getInterfaceComposantSingle(String name) {
		InterfaceComposantSingle returnedInterface = null;
		for (InterfaceComposantSingle ics : this.listInterfaces) {
			if (ics.getName().equals(name)) {
				returnedInterface = ics;
				break;
			}
		}
		return returnedInterface;
	}
	
}
