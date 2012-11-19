package metaModel.composant.composite;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompositeFournis extends ServiceComposite {

	//Aggrégation de ports
	List<PortComposantCompositeFournis> listPort;
	
	public ServiceCompositeFournis(){
		this.listPort = new ArrayList<PortComposantCompositeFournis>();
	}
	
	public void addPort(String name, PortComposantCompositeFournis port){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.add(i, port);
				return ;
			}
		}
		
		listPort.add(new PortComposantCompositeFournis(name));
	}
	
	public PortComposantCompositeFournis getPort(String name){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				return listPort.get(i);
			}
		}
		return null;
	}
	
	public void removePort(String name){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.remove(i);
			}
		}
	}
	
}
