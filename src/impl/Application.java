package impl;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import model.client.Client;
import model.connecteur.RPC;
import model.core.EnvoiClient;
import model.serveur.ServeurComposant;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n##### Client Creation #####");
		Client client = new Client("monClient");
		
		System.out.println("\n##### Server Creation #####");
		ServeurComposant serveurCompo = new ServeurComposant("monCompoServeur");
		
		System.out.println("\n##### RPC Creation #####");
		RPC rpc = new RPC("monRPC");
		
		System.out.println("\n##### Attachment Creation #####");
		PortComposantCompositeFourni port = (PortComposantCompositeFourni)client.getInterface("PortEnvoiClient");
		RoleCompositeRequis role = (RoleCompositeRequis)rpc.getInterfaceConnecteurComposite("RoleEnvoiClient");
		EnvoiClient envoieClient = new EnvoiClient(port, role);
	}

}
