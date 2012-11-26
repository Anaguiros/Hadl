package metaModel.composant.composite;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompositeRequis extends ServiceComposite {

	//Aggrégation de ports
	List<PortComposantCompositeRequis> listPort;
	
	/**
	 * Constructeur de Service Composite Requis
	 * @param name
	 */
	public ServiceCompositeRequis(String name){
		this.name = name;
		this.listPort = new ArrayList<PortComposantCompositeRequis>();
		
		System.out.println("Service Component Composite Required Creation : "+name);
	}
	
	/**
	 * Ajoute, ou met à jour, un port existant dans la liste de {@link PortComposantCompositeRequis} du service.
	 * @param name
	 * @param port
	 */
	public void addPort(String name, PortComposantCompositeRequis port){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.add(i, port);
				return ;
			}
		}
		
		listPort.add(new PortComposantCompositeRequis(name, this));
	}
	
	/**
	 * retourne un {@link PortComposantCompositeRequis} en fonction du nom précisé.
	 * @param name
	 * @return
	 */
	public PortComposantCompositeRequis getPort(String name){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				return listPort.get(i);
			}
		}
		return null;
	}
	
	/**
	 * supprime un {@link PortComposantCompositeRequis} de la liste du service. Si le nom précisé ne correspond à aucun port présent, la méthode ne fait rien.
	 * @param name
	 */
	public void removePort(String name){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.remove(i);
			}
		}
	}
	
}
