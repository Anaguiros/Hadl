package metaModel.composant.single;

import java.util.ArrayList;

public class ServiceSingleRequis extends ServiceSingle {

	//Aggrégation de ports
	private ArrayList<PortComposantSingleRequis> listPorts;
	
	public ServiceSingleRequis(String name) {
		this.name = name;
		this.listPorts = new ArrayList<PortComposantSingleRequis>();
	}
	
	public void addPortComposantSingleFourni(PortComposantSingleRequis port) {
		if (!this.listPorts.contains(port)) {
			this.listPorts.add(port);
		}
	}
	
	public void removePortComposantSingleFourni(PortComposantSingleRequis port) {
		if (this.listPorts.contains(port)) {
			this.listPorts.remove(port);
		}
	}
	
	public PortComposantSingleRequis getPortComposantSingleFourni(String name) {
		PortComposantSingleRequis returnedPort = null;
		for (PortComposantSingleRequis port : this.listPorts) {
			if (port.getName().equals(name)) {
				returnedPort = port;
				break;
			}
		}
		return returnedPort;
	}
}
