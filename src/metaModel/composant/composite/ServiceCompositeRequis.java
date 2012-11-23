package metaModel.composant.composite;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompositeRequis extends ServiceComposite {

	//Aggrégation de ports
	List<PortComposantCompositeRequis> listPort;
	
	public ServiceCompositeRequis(String name){
		this.name = name;
		this.listPort = new ArrayList<PortComposantCompositeRequis>();
		
		System.out.println("Service Component Composite Required Creation : "+name);
	}
	
	public void addPort(String name, PortComposantCompositeRequis port){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.add(i, port);
				return ;
			}
		}
		
		listPort.add(new PortComposantCompositeRequis(name));
	}
	
	public PortComposantCompositeRequis getPort(String name){
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
