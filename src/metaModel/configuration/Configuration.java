package metaModel.configuration;

import java.util.ArrayList;
import java.util.List;

import metaModel.core.Element;

public class Configuration extends Element {

	//Aggrégation d'instance d'Element
	List<Element> listElement;
	//Composition d'interfaces
	List<InterfaceConfiguration> listInterface;

	public Configuration(String name){
		this.name = name;
		this.listElement = new ArrayList<Element>();
		this.listInterface = new ArrayList<InterfaceConfiguration>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addElement(String name, Element element){
		for(int i=0;i<listElement.size();i++){
			if(listElement.get(i).getName().equalsIgnoreCase(name)){
				listElement.add(i, element);
				return ;
			}
		}
		listElement.add(element);
	}
	
	public Element getElement(String name){
		for(int i=0;i<listElement.size();i++){
			if(listElement.get(i).getName().equalsIgnoreCase(name)){
				return listElement.get(i);
			}
		}
		return null;
	}
	
	public void removeElement(String name){
		for(int i=0;i<listElement.size();i++){
			if(listElement.get(i).getName().equalsIgnoreCase(name)){
				listElement.remove(i);
			}
		}
	}
	
	public void addInterface(String name, InterfaceConfiguration interf){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.add(i, interf);
				return ;
			}
		}
		listInterface.add(interf);
	}
	
	public InterfaceConfiguration getInterface(String name){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				return listInterface.get(i);
			}
		}
		return null;
	}
	
	public void removeInterface(String name){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.remove(i);
			}
		}
	}
	
}
