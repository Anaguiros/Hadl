package metaModel.composant.composite;

import java.util.List;

import metaModel.composant.Composant;

public class ComposantComposite extends Composant {

	//Composition d'interfaces
	protected List<InterfaceComposantComposite> listInterface;
	
	public ComposantComposite(String name){
		this.name = name;
	}
	
	public void addInterface(String name){
		
	}
	
	public InterfaceComposantComposite getInterface(){
		
		return null;
		
	}
	
	public void removeInterface(){
		
	}
	
}
