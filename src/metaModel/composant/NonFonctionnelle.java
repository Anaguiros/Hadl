package metaModel.composant;

public class NonFonctionnelle extends Propriete {

	/**
	 * Constructeur de propriete non fonctionelle
	 * @param name
	 * @param value
	 */
	public NonFonctionnelle(String name, Object value){
		this.name=name;
		this.value=value;
		
		System.out.println("Property UnFonctionnal Creation : "+name);
	}
	
}
