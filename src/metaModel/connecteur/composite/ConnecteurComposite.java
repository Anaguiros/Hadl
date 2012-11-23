package metaModel.connecteur.composite;

import java.util.ArrayList;

import metaModel.connecteur.Connecteur;

public class ConnecteurComposite extends Connecteur {

	//Composition d'interfaces
	private ArrayList<InterfaceConnecteurComposite> listInterfaces;

	public ConnecteurComposite(String name) {
		this.name = name;
		this.listInterfaces = new ArrayList<InterfaceConnecteurComposite>();
		
		System.out.println("Connector Composite Creation : "+name);
	}
	
	public void addInterfaceConnecteurComposite(InterfaceConnecteurComposite icc) {
		if (!this.listInterfaces.contains(icc)) {
			this.listInterfaces.add(icc);
		}
	}
	
	public void removeInterfaceConnecteurComposite(String name) {
		for (InterfaceConnecteurComposite icc : this.listInterfaces) {
			if (icc.getName().equals(name)) {
				this.listInterfaces.remove(icc);
				break;
			}
		}
	}
	
	public InterfaceConnecteurComposite getInterfaceConnecteurComposite(String name) {
		InterfaceConnecteurComposite returnedIcc = null;
		for (InterfaceConnecteurComposite icc : this.listInterfaces) {
			if (icc.getName().equals(name)) {
				returnedIcc = icc;
				break;
			}
		}
		return returnedIcc;
	}
	
	@Override
	protected void glue() {
		// TODO Auto-generated method stub
		
	}
	
}
