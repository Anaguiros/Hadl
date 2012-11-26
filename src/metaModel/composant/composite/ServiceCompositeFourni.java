package metaModel.composant.composite;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompositeFourni extends ServiceComposite {

	//Aggrégation de ports
	List<PortComposantCompositeFourni> listPort;
		
	public ServiceCompositeFourni(String name){
		this.name = name;
		this.listPort = new ArrayList<PortComposantCompositeFourni>();
		
		System.out.println("Service Component Composite Provided Creation : "+name);
	}
	
	public void addPort(String name, PortComposantCompositeFourni port){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.add(i, port);
				return ;
			}
		}
		
		listPort.add(new PortComposantCompositeFourni(name, this));
	}
	
	public PortComposantCompositeFourni getPort(String name){
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
