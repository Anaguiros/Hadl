package metaModel.composant.composite;

public class PortComposantCompositeFourni extends PortComposantComposite {

	public PortComposantCompositeFourni(String name){
		this.name = name;
		
		System.out.println("Port Component Composite Provided Creation : "+name);
	}
	
	public void sendMessage(String msg){
		setChanged();
		notifyObservers(msg);
	}
}
