package metaModel.composant.composite;

import java.util.ArrayList;
import java.util.List;

import metaModel.composant.Composant;
import metaModel.composant.Propriete;
import metaModel.connecteur.composite.ConnecteurComposite;

public class ComposantComposite extends Composant {

	//Composition d'interfaces
	protected List<InterfaceComposantComposite> listInterface;
	
	/**
	 * Constructeur d'un composant composite. Un composant Composite peut se lier à d'autre {@link ComposantComposite}, via des {@link ConnecteurComposite}.
	 * @param name
	 */
	public ComposantComposite(String name){
		this.name = name;
		this.listInterface = new ArrayList<InterfaceComposantComposite>();
		this.listPropriete = new ArrayList<Propriete>();
		
		System.out.println("Component Creation Composite : "+name);
	}
	
	/**
	 * Ajoute, ou met à jour, un {@link InterfaceComposantComposite} existante.
	 * @param name
	 * @param interf
	 */
	public void addInterface(String name, InterfaceComposantComposite interf){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				listInterface.add(i, interf);
				return ;
			}
		}
		listInterface.add(interf);
	}
	
	/**
	 * Retourne une {@link InterfaceComposantComposite}, en précisant son nom.
	 * @param name
	 * @return
	 */
	public InterfaceComposantComposite getInterface(String name){
		for(int i=0;i<listInterface.size();i++){
			if(listInterface.get(i).getName().equalsIgnoreCase(name)){
				return listInterface.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Supprime une {@link InterfaceComposantComposite} présente dans la liste des interfaces du {@link ComposantComposite}. Si l'interface n'est pas présente, la méthode ne fait rien.
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
