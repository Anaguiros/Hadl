package impl;

import metaModel.composant.composite.ComposantComposite;
import metaModel.composant.composite.PortComposantCompositeFourni;
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
import model.serveur.attachments.AuthComputing;
import model.serveur.attachments.AuthResults;
import model.serveur.attachments.Requete;
import model.serveur.attachments.RequeteAuth;
import model.serveur.attachments.RequeteSQL;
import model.serveur.attachments.RequeteSecurity;
import model.serveur.attachments.ResultAuth;
import model.serveur.attachments.Resultat;
import model.serveur.attachments.ResultatSQL;
import model.serveur.attachments.ResultatSecurity;
import model.serveur.attachments.SecurityComputing;
import model.serveur.attachments.SecurityResults;
import model.serveur.connector.clearanceRequest.ClearanceRequest;
import model.serveur.connector.securityQuery.SecurityQuery;
import model.serveur.connector.sqlQuery.SQLQuery;
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
		
		/*
		System.out.println("\n##### Intern Connectors Creation #####");
		ClearanceRequest clearanceRequest = new ClearanceRequest("ClearanceRequest");
		SQLQuery slqQuery = new SQLQuery("SQLQuery");
		SecurityQuery securityQuery = new SecurityQuery("SecurityQuery");

		System.out.println("\n##### Attachment Configuration Creation #####");
		
		PortComposantCompositeRequis pConfigReq;
		PortComposantCompositeFourni pConfigFour;
		RoleCompositeFourni rFour;
		RoleCompositeRequis rReq;
		
		ResultAuth resultAuth = new ResultAuth(((ServiceCompositeRequis)((ComposantComposite)serveurConfig.getElement("ConnexionManager")).getInterface("ServiceResultsAuth")).getPort("PortResultsAuth"),
				(RoleCompositeFourni)clearanceRequest.getInterfaceConnecteurComposite("RoleResultsAuth"));
		
		pConfigFour = ((ServiceCompositeFourni)((ComposantComposite)serveurConfig.getElement("ConnexionManager")).getInterface("ServiceRequeteAuth")).getPort("PortRequeteAuth");
		rReq = (RoleCompositeRequis)clearanceRequest.getInterfaceConnecteurComposite("RoleRequeteAuth");
		
		RequeteAuth requeteAuth = new RequeteAuth(pConfigFour, rReq);
		
		pConfigReq = ((ServiceCompositeRequis)((ComposantComposite)serveurConfig.getElement("ConnexionManager")).getInterface("ServiceResultat")).getPort("PortResultat");
		rFour = (RoleCompositeFourni)slqQuery.getInterfaceConnecteurComposite("RoleResultat");
		
		Resultat resultat = new Resultat(pConfigReq, rFour);
		
		pConfigFour = ((ServiceCompositeFourni)((ComposantComposite)serveurConfig.getElement("ConnexionManager")).getInterface("ServiceRequete")).getPort("PortRequete");
		rReq = (RoleCompositeRequis)slqQuery.getInterfaceConnecteurComposite("RoleRequete");
		
		Requete requete = new Requete(pConfigFour, rReq);
		
		pConfigFour = ((ServiceCompositeFourni)((ComposantComposite)serveurConfig.getElement("SecurityManager")).getInterface("ServiceAuthResults")).getPort("PortAuthResults");
		rReq = (RoleCompositeRequis)clearanceRequest.getInterfaceConnecteurComposite("RoleAuthResults");
		
		AuthResults authResults = new AuthResults(pConfigFour, rReq);
		
		pConfigReq = ((ServiceCompositeRequis)((ComposantComposite)serveurConfig.getElement("SecurityManager")).getInterface("ServiceAuthComputing")).getPort("PortAuthComputing");
		rFour = (RoleCompositeFourni)clearanceRequest.getInterfaceConnecteurComposite("RoleAuthComputing");
		
		AuthComputing authComputing = new AuthComputing(pConfigReq, rFour);
		
		pConfigFour = ((ServiceCompositeFourni)((ComposantComposite)serveurConfig.getElement("SecurityManager")).getInterface("ServiceSecurityResults")).getPort("PortSecurityResults");
		rReq = (RoleCompositeRequis)securityQuery.getInterfaceConnecteurComposite("RoleSecurityResults");
		
		SecurityResults securityResults = new SecurityResults(pConfigFour, rReq);
		
		pConfigReq = ((ServiceCompositeRequis)((ComposantComposite)serveurConfig.getElement("SecurityManager")).getInterface("ServiceSecurityComputing")).getPort("PortSecurityComputing");
		rFour = (RoleCompositeFourni)securityQuery.getInterfaceConnecteurComposite("RoleSecurityComputing");
		
		SecurityComputing securityComputing = new SecurityComputing(pConfigReq, rFour);
		
		pConfigReq = ((ServiceCompositeRequis)((ComposantComposite)serveurConfig.getElement("Database")).getInterface("ServiceRequeteSQL")).getPort("PortRequeteSQL");
		rFour = (RoleCompositeFourni)slqQuery.getInterfaceConnecteurComposite("RoleRequeteSQL");
		
		RequeteSQL requeteSQL = new RequeteSQL(pConfigReq, rFour);
		
		pConfigFour = ((ServiceCompositeFourni)((ComposantComposite)serveurConfig.getElement("Database")).getInterface("ServiceResultatSQL")).getPort("PortResultatSQL");
		rReq = (RoleCompositeRequis)slqQuery.getInterfaceConnecteurComposite("RoleResultatSQL");
		
		ResultatSQL resultatSQL = new ResultatSQL(pConfigFour, rReq);
		
		pConfigFour = ((ServiceCompositeFourni)((ComposantComposite)serveurConfig.getElement("Database")).getInterface("ServiceRequeteSecurity")).getPort("PortRequeteSecurity");
		rReq = (RoleCompositeRequis)securityQuery.getInterfaceConnecteurComposite("RoleRequeteSecurity");
		
		RequeteSecurity requeteSecurity = new RequeteSecurity(pConfigFour, rReq);
		
		pConfigReq = ((ServiceCompositeRequis)((ComposantComposite)serveurConfig.getElement("Database")).getInterface("ServiceResultatSecurity")).getPort("PortResultatSecurity");
		rFour = (RoleCompositeFourni)securityQuery.getInterfaceConnecteurComposite("RoleResultatSecurity");
		
		ResultatSecurity resultatSecurity = new ResultatSecurity(pConfigReq, rFour);
		*/
		
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
		client.send("Test message client");
		System.out.println("-----------------------------------------------------------------------------------");
		serveurCompo.send(serveurCompo.getInterface("ServiceConnexionConfigServeur"));
		System.out.println("-----------------------------------------------------------------------------------");
		serveurCompo.execute(new Object());
		System.out.println("-----------------------------------------------------------------------------------");
		
	}
}
