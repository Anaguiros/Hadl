package metaModel.configuration;

import java.util.ArrayList;
import java.util.List;

import metaModel.core.Element;

public class Configuration extends Element {

	//Aggrégation d'instance d'Element
	List<Element> listElement;
	//Composition d'interfaces
	List<InterfaceConfiguration> listInterface;

	/**
	 * Constructeur de Configuration.
	 * @param name
	 */
	public Configuration(String name){
		this.name = name;
		this.listElement = new ArrayList<Element>();
		this.listInterface = new ArrayList<InterfaceConfiguration>();
		
		System.out.println("Configuration Creation : "+name);
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * Ajoute un {@link Element} dans la liste des élèment contenus par la configuration.
	 * @param name
	 * @param element
	 */
	public void addElement(String name, Element element){
		for(int i=0;i<listElement.size();i++){
			if(listElement.get(i).getName().equalsIgnoreCase(name)){
				listElement.add(i, element);
				return ;
			}
		}
		listElement.add(element);
	}
	
	/**
	 * Retourne un {@link Element} de la liste, en fonction du nom précisé.
	 * @param name
	 * @return
	 */
	public Element getElement(String name){
		for(int i=0;i<listElement.size();i++){
			if(listElement.get(i).getName().equalsIgnoreCase(name)){
				return listElement.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Supprime un {@link Element} présent dans la liste des élèment contenus par la configuration. Si l'élèment n'est pas présent, la méthode ne fait rien.
	 * @param name
	 */
	public void removeElement(String name){
		for(int i=0;i<listElement.size();i++){
			if(listElement.get(i).getName().equalsIgnoreCase(name)){
				listElement.remove(i);
			}
		}
	}
	
	/**
	 * Ajoute une {@link InterfaceConfiguration} à la liste des interfaces de la configuration.
	 * @param name
	 * @param interf
	 */
	public void addInterface(String name, InterfaceConfiguration interf){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.add(i, interf);
				return ;
			}
		}
		listInterface.add(interf);
	}
	
	/**
	 * Retourne une {@link InterfaceConfiguration} en fonction du nom précisé.
	 * @param name
	 * @return
	 */
	public InterfaceConfiguration getInterface(String name){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				return listInterface.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Supprime une {@link InterfaceConfiguration} de la liste des interfaces de la configuration. Si l'interface n'est pas présente dans la liste, la méthode ne fait rien.
	 * @param name
	 */
	public void removeInterface(String name){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.remove(i);
			}
		}
	}
	
}
