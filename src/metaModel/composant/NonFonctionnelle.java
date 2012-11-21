package metaModel.composant;

public class NonFonctionnelle extends Propriete {

	public NonFonctionnelle(String name, Object value){
		this.name=name;
		this.value=value;
		
		System.out.println("Property UnFonctionnal Creation : "+name);
	}
	
}
