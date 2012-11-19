package metaModel.composant.composite;

import java.util.List;

import metaModel.composant.Composant;

public class ComposantComposite extends Composant {

	//Composition d'interfaces
	protected List<InterfaceComposantComposite> listInterface;
	
	public ComposantComposite(String name){
		this.name = name;
	}
	
	public void addInterface(String name, InterfaceComposantComposite interf){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.add(i, interf);
				return ;
			}
		}
		listInterface.add(interf);
	}
	
	public InterfaceComposantComposite getInterface(){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				return listInterface.get(i);
			}
		}
		return null;
	}
	
	public void removeInterface(){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.remove(i);
			}
		}
	}
	
}
