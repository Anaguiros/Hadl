package metaModel.composant.single;

import java.util.ArrayList;

public class ServiceSingleFourni extends ServiceSingle {

	//Aggrégation de ports
	private ArrayList<PortComposantSingleFourni> listPorts;
	
	public ServiceSingleFourni(String name) {
		this.name = name;
		this.listPorts = new ArrayList<PortComposantSingleFourni>();
		
		System.out.println("Service Component Single Provided Creation : "+name);
	}
	
	public void addPortComposantSingleFourni(PortComposantSingleFourni port) {
		if (!this.listPorts.contains(port)) {
			this.listPorts.add(port);
		}
	}
	
	public void removePortComposantSingleFourni(PortComposantSingleFourni port) {
		if (this.listPorts.contains(port)) {
			this.listPorts.remove(port);
		}
	}
	
	public PortComposantSingleFourni getPortComposantSingleFourni(String name) {
		PortComposantSingleFourni returnedPort = null;
		for (PortComposantSingleFourni port : this.listPorts) {
			if (port.getName().equals(name)) {
				returnedPort = port;
				break;
			}
		}
		return returnedPort;
	}
	
}
