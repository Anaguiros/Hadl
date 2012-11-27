package impl;

import model.attachments.EnvoiClient;
import model.attachments.EnvoiServeur;
import model.attachments.ReceptionClient;
import model.attachments.ReceptionServeur;
import model.client.Client;
import model.client.PortEnvoiClient;
import model.client.PortReceptionClient;
import model.client.ServiceEnvoiClient;
import model.client.ServiceReceptionClient;
import model.connecteur.RPC;
import model.connecteur.RoleEnvoiClient;
import model.connecteur.RoleEnvoiServeur;
import model.connecteur.RoleReceptionClient;
import model.connecteur.RoleReceptionServeur;
import model.core.BindConnexionServeur;
import model.core.BindServeur;
import model.core.ConnexionMessage;
import model.serveur.ConnexionComposantServeur;
import model.serveur.PortConnexionConfigServeur;
import model.serveur.PortConnexionServer;
import model.serveur.PortEnvoiServeur;
import model.serveur.PortReceptionServeur;
import model.serveur.ServeurComposant;
import model.serveur.ServeurConfiguration;
import model.serveur.ServiceConnexionConfigServeur;
import model.serveur.ServiceEnvoiServeur;
import model.serveur.ServiceReceptionServeur;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.connexionManager.PortConnexion;

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
				
		PortEnvoiClient pec = ((ServiceEnvoiClient) client.getInterface("ServiceEnvoiClient")).getPortEnvoiClient();
		RoleEnvoiClient rec = (RoleEnvoiClient)rpc.getInterfaceConnecteurComposite("RoleEnvoiClient");
		EnvoiClient envoiClient = new EnvoiClient(pec, rec);
		
		PortReceptionClient prc = ((ServiceReceptionClient)client.getInterface("ServiceReceptionClient")).getPortReceptionClient();
		RoleReceptionClient rrc = (RoleReceptionClient) rpc.getInterfaceConnecteurComposite("RoleReceptionClient");
		ReceptionClient receptionClient = new ReceptionClient(prc,rrc);
		
		PortEnvoiServeur pes = ((ServiceEnvoiServeur) serveurCompo.getInterface("ServiceEnvoiServeur")).getPortEnvoi();
		RoleEnvoiServeur res = (RoleEnvoiServeur)rpc.getInterfaceConnecteurComposite("RoleEnvoiServeur");
		EnvoiServeur envoiServeur = new EnvoiServeur(pes, res);
		
		PortReceptionServeur prs = ((ServiceReceptionServeur)serveurCompo.getInterface("ServiceReceptionServeur")).getPortReception();
		RoleReceptionServeur rrs = (RoleReceptionServeur) rpc.getInterfaceConnecteurComposite("RoleReceptionServeur");
		ReceptionServeur receptionServeur = new ReceptionServeur(prs,rrs);
		
		System.out.println("\n##### Binding Component-Configuration #####");
		
		ConnexionManager cm = (ConnexionManager) serveurConfig.getElement("ConnexionManager");
		PortConnexion pc = cm.getServiceConnexion().getPortConnexion();
		PortConnexionServer pcs = (PortConnexionServer) serveurConfig.getInterface("PortConnexionServeur");
		
		//Bind interne à Serveur
		BindConnexionServeur bindConnexionServeur = new BindConnexionServeur(pcs, pc);
		
		//Bind Compo--Config
		ConnexionComposantServeur ccs = (ConnexionComposantServeur)(serveurConfig.getInterface("ConnexionComposantServeur"));
		PortConnexionConfigServeur sccs = ((ServiceConnexionConfigServeur) serveurCompo.getInterface("ServiceConnexionConfigServeur")).getPortConnexionConfig();
		BindServeur bindServeur = new BindServeur(ccs, sccs);
		
		System.out.println("\n##### Mise en place des observers #####");
		
		//((ServiceEnvoiClient)client.getInterface("ServiceEnvoiClient")).getPortEnvoiClient().addObserver(envoiClient);
		//((ServiceReceptionClient)client.getInterface("ServiceReceptionClient")).getPortReceptionClient().addObserver(client);
		
		System.out.println("\n##### Execution des méthodes glue() #####");
		rpc.glue();
		
		System.out.println("\n##### Envois #####");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("   | Class                | Details");
		System.out.println("-----------------------------------------------------------------------------------");
		client.send(new ConnexionMessage("toto", "tutu", "SELECT * FROM *"));
		System.out.println("-----------------------------------------------------------------------------------");
		serveurCompo.send(serveurCompo.getInterface("ServiceConnexionConfigServeur"));
		System.out.println("-----------------------------------------------------------------------------------");
		serveurCompo.execute(new Object());
		System.out.println("-----------------------------------------------------------------------------------");
		
	}
}
