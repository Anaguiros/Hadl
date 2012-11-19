package metaModel.composant;

import java.util.List;

import metaModel.core.Element;

public abstract class Composant extends Element {

	//Composition d'instance de Propriete
	protected List<Propriete> listPropriete;
	
	/**
	 * Ajoute, ou met à jour, une propriete fonctionnelle existante.
	 * @param name
	 * @param value
	 */
	public void addProprieteFonctionnelle(String name, Object value){
		
		
		for(int i=0;i<listPropriete.size();i++){
			if(listPropriete.get(i).getName().equalsIgnoreCase(name)){
				listPropriete.get(i).setValue(value);
				return ;
			}
		}
		
		listPropriete.add(new Fonctionnelle(name,value));
		
	}
	
	/**
	 * Ajoute, ou met à jour, une propriete fonctionnelle existante.
	 * @param name
	 * @param value
	 */
	public void addProprieteNonFonctionnelle(String name, Object value){
		
		for(int i=0;i<listPropriete.size();i++){
			if(listPropriete.get(i).getName().equalsIgnoreCase(name)){
				listPropriete.get(i).setValue(value);
				return ;
			}
		}
		
		listPropriete.add(new NonFonctionnelle(name,value));
	}
	
	/**
	 * return une propriete existante. Retourne null si la proproete n'existe pas.
	 * @param name
	 * @return
	 */
	public Propriete getPropriete(String name){
		
		for(int i=0;i<listPropriete.size();i++){
			if(listPropriete.get(i).getName().equalsIgnoreCase(name)){
				return listPropriete.get(i);
			}
		}		
		return null;	
	}
	
	/**
	 * remove une propriete existante. Ne fais rien si la propriete n'existe pas.
	 * @param name
	 */
	public void removePropriete(String name){
		for(int i=0;i<listPropriete.size();i++){
			if(listPropriete.get(i).getName().equalsIgnoreCase(name)){
				listPropriete.remove(i);
			}
		}
	}
}
