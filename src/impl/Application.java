package impl;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeFourni;
import metaModel.composant.composite.ServiceCompositeRequis;
import metaModel.configuration.PortConfigRequis;
import metaModel.connecteur.composite.RoleCompositeFourni;
import metaModel.connecteur.composite.RoleCompositeRequis;
import model.attachments.EnvoiClient;
import model.attachments.EnvoiServeur;
import model.attachments.ReceptionClient;
import model.attachments.ReceptionServeur;
import model.client.Client;
import model.connecteur.RPC;
import model.core.BindConnexionServeur;
import model.core.BindServeur;
import model.serveur.ServeurComposant;
import model.serveur.ServeurConfiguration;
import model.serveur.connexionManager.ConnexionManager;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("##### Client Creation #####");
		Client client = new Client("monClient");
		
		System.out.println("\n##### Server Component Creation #####");
		ServeurComposant serveurCompo = new ServeurComposant("monCompoServeur");
		
		System.out.println("\n##### Server Configuration Creation #####");
		ServeurConfiguration serveurConfig = new ServeurConfiguration("maConfigServeur");
		
		System.out.println("\n##### RPC Creation #####");
		RPC rpc = new RPC("monRPC");
		
		System.out.println("\n##### Attachment Creation #####");
		
		EnvoiClient envoiClient = new EnvoiClient(((ServiceCompositeFourni)client.getInterface("ServiceEnvoiClient")).getPort("PortEnvoiClient"), 
				(RoleCompositeRequis)rpc.getInterfaceConnecteurComposite("RoleEnvoiClient"));
		
		ReceptionClient receptionClient = new ReceptionClient(((ServiceCompositeRequis)client.getInterface("ServiceReceptionClient")).getPort("PortReceptionClient"),
				(RoleCompositeFourni) rpc.getInterfaceConnecteurComposite("RoleReceptionClient"));
				
		EnvoiServeur envoiServeur = new EnvoiServeur(((ServiceCompositeFourni)serveurCompo.getInterface("ServiceEnvoiServeur")).getPort("PortEnvoiServeur"), 
				(RoleCompositeRequis)rpc.getInterfaceConnecteurComposite("RoleEnvoiServeur"));
		
		ReceptionServeur receptionServeur = new ReceptionServeur(((ServiceCompositeRequis)serveurCompo.getInterface("ServiceReceptionServeur")).getPort("PortReceptionServeur"), 
				(RoleCompositeFourni) rpc.getInterfaceConnecteurComposite("RoleReceptionServeur"));
		
		System.out.println("\n##### Binding Component-Configuration #####");
		
		PortConfigRequis pConf = (PortConfigRequis)(serveurConfig.getInterface("PortConnexionServeur"));
		PortComposantCompositeRequis pCom = ((ServiceCompositeRequis)((ConnexionManager)serveurConfig.getElement("ConnexionManager")).getInterface("ServiceConnexion")).getPort("PortConnexion");
		
		//Bind interne à Serveur
		BindConnexionServeur bindConnexionServeur = new BindConnexionServeur(pConf, pCom);
		
		//Bind Compo--Config
		pConf = (PortConfigRequis)(serveurConfig.getInterface("ConnexionComposantServeur"));
		pCom = ((ServiceCompositeRequis)serveurCompo.getInterface("ServiceConnexionConfigServeur")).getPort("PortConnexionConfigServeur");
		BindServeur bindServeur = new BindServeur(pConf, pCom);
	}
}
