package metaModel.composant.composite;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompositeFourni extends ServiceComposite {

	//Aggrégation de ports
	List<PortComposantCompositeFourni> listPort;
	
	/**
	 * Constructeur de Service Composite Fourni
	 * @param name
	 */
	public ServiceCompositeFourni(String name){
		this.name = name;
		this.listPort = new ArrayList<PortComposantCompositeFourni>();
		
		System.out.println("Service Component Composite Provided Creation : "+name);
	}
	
	/**
	 * Ajoute, ou met à jour, un port existant dans la liste de {@link PortComposantCompositeFourni} du service.
	 * @param name
	 * @param port
	 */
	public void addPort(String name, PortComposantCompositeFourni port){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				listPort.add(i, port);
				return ;
			}
		}
		
		listPort.add(new PortComposantCompositeFourni(name, this));
	}
	
	/**
	 * retourne un {@link PortComposantCompositeFourni} en fonction du nom précisé.
	 * @param name
	 * @return
	 */
	public PortComposantCompositeFourni getPort(String name){
		for(int i=0;i<listPort.size();i++){
			if(listPort.get(i).getName().equalsIgnoreCase(name)){
				return listPort.get(i);
			}
		}
		return null;
	}
	
	/**
	 * supprime un {@link PortComposantCompositeFourni} de la liste du service. Si le nom précisé ne correspond à aucun port présent, la méthode ne fait rien.
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
