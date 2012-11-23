package metaModel.composant;

public class Fonctionnelle extends Propriete {

	public Fonctionnelle(String name, Object value){
		this.name=name;
		this.value=value;
		
		System.out.println("Property Fonctionnal Creation : "+name);
	}
	
}
