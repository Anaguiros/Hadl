package metaModel.connecteur.single;

import java.util.ArrayList;

import metaModel.connecteur.Connecteur;

public class ConnecteurSingle extends Connecteur {

	//Composition d'interfaces
	private ArrayList<InterfaceConnecteurSingle> listInterfaces;

	public ConnecteurSingle(String name) {
		this.name = name;
		this.listInterfaces = new ArrayList<InterfaceConnecteurSingle>();
	}
	
	public void addInterfaceConnecteurSingle(InterfaceConnecteurSingle ics) {
		if (!this.listInterfaces.contains(ics)) {
			this.listInterfaces.add(ics);
		}
	}
	
	public void removeInterfaceConnecteurSingle(String name) {
		for (InterfaceConnecteurSingle ics : this.listInterfaces) {
			if (ics.getName().equals(name)) {
				this.listInterfaces.remove(ics);
				break;
			}
		}
	}
	
	public InterfaceConnecteurSingle getInterfaceConnecteurSingle(String name) {
		InterfaceConnecteurSingle returnedIcs = null;
		for (InterfaceConnecteurSingle ics : this.listInterfaces) {
			if (ics.getName().equals(name)) {
				returnedIcs = ics;
				break;
			}
		}
		return returnedIcs;
	}
	
	@Override
	protected void glue() {
		// TODO Auto-generated method stub
		
	}
	
	
}
