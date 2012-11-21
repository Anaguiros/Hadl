package impl;

import metaModel.composant.composite.PortComposantCompositeFourni;
import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeFourni;
import metaModel.composant.composite.ServiceCompositeRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import model.attachments.EnvoiClient;
import model.attachments.EnvoiServeur;
import model.attachments.ReceptionClient;
import model.attachments.ReceptionServeur;
import model.client.Client;
import model.connecteur.RPC;
import model.serveur.ServeurComposant;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("##### Client Creation #####");
		Client client = new Client("monClient");
		
		System.out.println("\n##### Server Creation #####");
		ServeurComposant serveurCompo = new ServeurComposant("monCompoServeur");
		
		System.out.println("\n##### RPC Creation #####");
		RPC rpc = new RPC("monRPC");
		
		System.out.println("\n##### Attachment Creation #####");
		
		EnvoiClient envoiClient = new EnvoiClient(((ServiceCompositeFourni)client.getInterface("ServiceEnvoiClient")).getPort("PortEnvoiClient"), 
				(RoleCompositeRequis)rpc.getInterfaceConnecteurComposite("RoleEnvoiClient"));
		
		ReceptionClient receptionClient = new ReceptionClient(((ServiceCompositeRequis)client.getInterface("ServiceReceptionClient")).getPort("PortReceptionClient"),
				(RoleCompositeFourni) rpc.getInterfaceConnecteurComposite("RoleReceptionClient"));
		
//		PortComposantCompositeFourni pFour = ((ServiceCompositeFourni)serveurCompo.getInterface("ServiceEnvoiServeur")).getPort("PortEnvoiServeur");
//		RoleCompositeRequis rReq = (RoleCompositeRequis)rpc.getInterfaceConnecteurComposite("RoleEnvoiServeur");
		
		EnvoiServeur envoiServeur = new EnvoiServeur(((ServiceCompositeFourni)serveurCompo.getInterface("ServiceEnvoiServeur")).getPort("PortEnvoiServeur"), 
				(RoleCompositeRequis)rpc.getInterfaceConnecteurComposite("RoleEnvoiServeur"));
		
		ReceptionServeur receptionServeur = new ReceptionServeur(((ServiceCompositeRequis)serveurCompo.getInterface("ServiceReceptionServeur")).getPort("PortReceptionServeur"), 
				(RoleCompositeFourni) rpc.getInterfaceConnecteurComposite("RoleReceptionServeur"));
	}

}
