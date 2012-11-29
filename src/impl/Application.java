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
import model.core.QueryMessage;
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
import model.serveur.connector.clearanceRequest.RoleAuthComputing;
import model.serveur.connector.clearanceRequest.RoleAuthResults;
import model.serveur.connector.clearanceRequest.RoleRequeteAuth;
import model.serveur.connector.clearanceRequest.RoleResultsAuth;
import model.serveur.connector.securityQuery.RoleRequeteSecurity;
import model.serveur.connector.securityQuery.RoleResultatSecurity;
import model.serveur.connector.securityQuery.RoleSecurityComputing;
import model.serveur.connector.securityQuery.RoleSecurityResults;
import model.serveur.connector.securityQuery.SecurityQuery;
import model.serveur.connector.sqlQuery.RoleRequete;
import model.serveur.connector.sqlQuery.RoleRequeteSQL;
import model.serveur.connector.sqlQuery.RoleResultat;
import model.serveur.connector.sqlQuery.RoleResultatSQL;
import model.serveur.connector.sqlQuery.SQLQuery;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.connexionManager.PortConnexion;
import model.serveur.connexionManager.PortRequete;
import model.serveur.connexionManager.PortRequeteAuth;
import model.serveur.connexionManager.PortResultat;
import model.serveur.connexionManager.PortResultsAuth;
import model.serveur.connexionManager.ServiceConnexion;
import model.serveur.connexionManager.ServiceRequete;
import model.serveur.connexionManager.ServiceRequeteAuth;
import model.serveur.connexionManager.ServiceResultat;
import model.serveur.connexionManager.ServiceResultsAuth;
import model.serveur.database.Database;
import model.serveur.database.PortRequeteSQL;
import model.serveur.database.PortRequeteSecurity;
import model.serveur.database.PortResultatSQL;
import model.serveur.database.PortResultatSecurity;
import model.serveur.database.ServiceRequeteSQL;
import model.serveur.database.ServiceRequeteSecurity;
import model.serveur.database.ServiceResultatSQL;
import model.serveur.database.ServiceResultatSecurity;
import model.serveur.securityManager.PortAuthComputing;
import model.serveur.securityManager.PortAuthResults;
import model.serveur.securityManager.PortSecurityComputing;
import model.serveur.securityManager.PortSecurityResults;
import model.serveur.securityManager.SecurityManager;
import model.serveur.securityManager.ServiceAuthComputing;
import model.serveur.securityManager.ServiceAuthResults;
import model.serveur.securityManager.ServiceSecurityComputing;
import model.serveur.securityManager.ServiceSecurityResults;

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
		
		System.out.println("\n##### Connectors Creation #####");
		RPC rpc = new RPC("monRPC");
		ClearanceRequest cr = new ClearanceRequest("monClearanceRequest");
		SQLQuery sqlq = new SQLQuery("mySQLQuery");
		SecurityQuery sq = new SecurityQuery("mySecurityQuery");
		
		System.out.println("\n##### Attachment Creation #####");
				
		PortEnvoiClient pec = ((ServiceEnvoiClient) client.getInterface("ServiceEnvoiClient")).getPortEnvoiClient();
		RoleEnvoiClient rec = (RoleEnvoiClient)rpc.getInterfaceConnecteurComposite("RoleEnvoiClient");
		new EnvoiClient(pec, rec);
		
		PortReceptionClient prc = ((ServiceReceptionClient)client.getInterface("ServiceReceptionClient")).getPortReceptionClient();
		RoleReceptionClient rrc = (RoleReceptionClient) rpc.getInterfaceConnecteurComposite("RoleReceptionClient");
		new ReceptionClient(prc,rrc);
		
		PortEnvoiServeur pes = ((ServiceEnvoiServeur) serveurCompo.getInterface("ServiceEnvoiServeur")).getPortEnvoi();
		RoleEnvoiServeur res = (RoleEnvoiServeur)rpc.getInterfaceConnecteurComposite("RoleEnvoiServeur");
		new EnvoiServeur(pes, res);
		
		PortReceptionServeur prs = ((ServiceReceptionServeur)serveurCompo.getInterface("ServiceReceptionServeur")).getPortReception();
		RoleReceptionServeur rrs = (RoleReceptionServeur) rpc.getInterfaceConnecteurComposite("RoleReceptionServeur");
		new ReceptionServeur(prs,rrs);
		
		SecurityManager securityMgr = (SecurityManager) serveurConfig.getElement("SecurityManager");
		
		PortAuthResults par = ((ServiceAuthResults) securityMgr.getInterface("ServiceAuthResults")).getPortAuthResults();
		RoleAuthResults rar = (RoleAuthResults) cr.getInterfaceConnecteurComposite("RoleAuthResults");
		new AuthResults(par, rar);
		
		PortAuthComputing pac = ((ServiceAuthComputing) securityMgr.getInterface("serviceAuthComputing")).getPortAuthComputing();
		RoleAuthComputing rac = (RoleAuthComputing) cr.getInterfaceConnecteurComposite("RoleAuthComputing");
		new AuthComputing(pac, rac);
		
		PortSecurityResults psr = ((ServiceSecurityResults) securityMgr.getInterface("ServiceSecurityResults")).getPortSecurityResults();
		RoleSecurityResults rsr = (RoleSecurityResults) sq.getInterfaceConnecteurComposite("RoleSecurityResults");
		new SecurityResults(psr, rsr);
		
		PortSecurityComputing psc = ((ServiceSecurityComputing) securityMgr.getInterface("ServiceSecurityComputing")).getPortSecurityComputing();
		RoleSecurityComputing rsc = (RoleSecurityComputing) sq.getInterfaceConnecteurComposite("RoleSecurityComputing");
		new SecurityComputing(psc, rsc);
		
		Database database = (Database) serveurConfig.getElement("Database");
		
		PortResultatSecurity prs2 = ((ServiceResultatSecurity) database.getInterface("serviceResultatSecurity")).getPortResultatSecurity();
		RoleResultatSecurity rrs2 = (RoleResultatSecurity) sq.getInterfaceConnecteurComposite("RoleResultatSecurity");
		new ResultatSecurity(prs2, rrs2);
		
		PortRequeteSecurity prs3 = ((ServiceRequeteSecurity) database.getInterface("ServiceRequeteSecurity")).getPortRequeteSecurity();
		RoleRequeteSecurity rrs3 = (RoleRequeteSecurity) sq.getInterfaceConnecteurComposite("RoleRequeteSecurity");
		new RequeteSecurity(prs3, rrs3);
		
		PortRequeteSQL prsql = ((ServiceRequeteSQL) database.getInterface("ServicerequeteSQL")).getPortRequeteSQL();
		RoleRequeteSQL rrsql = (RoleRequeteSQL) sqlq.getInterfaceConnecteurComposite("RoleRequeteSQL");
		new RequeteSQL(prsql, rrsql);
		
		PortResultatSQL prsql2 = ((ServiceResultatSQL) database.getInterface("ServiceResultatSQL")).getPortResultatSQL();
		RoleResultatSQL rrsql2 = (RoleResultatSQL) sqlq.getInterfaceConnecteurComposite("RoleResultatSQL");
		new ResultatSQL(prsql2, rrsql2);
		
		ConnexionManager connexionMgr = (ConnexionManager) serveurConfig.getElement("ConnexionManager");
		
		PortResultat pr = ((ServiceResultat) connexionMgr.getInterface("ServiceResultat")).getPortResultat();
		RoleResultat rr = (RoleResultat) sqlq.getInterfaceConnecteurComposite("RoleResultat");
		new Resultat(pr, rr);
		
		PortRequete pr2 = ((ServiceRequete) connexionMgr.getInterface("ServiceRequete")).getPortRequete();
		RoleRequete rr2 = (RoleRequete) sqlq.getInterfaceConnecteurComposite("RoleRequete");
		new Requete(pr2, rr2);
		
		PortResultsAuth pra = ((ServiceResultsAuth) connexionMgr.getInterface("ServiceResultsAuth")).getPortResultsAuth();
		RoleResultsAuth rra = (RoleResultsAuth) cr.getInterfaceConnecteurComposite("RoleResultsAuth");
		new ResultAuth(pra, rra);
		
		PortRequeteAuth pra2 = ((ServiceRequeteAuth) connexionMgr.getInterface("ServiceRequeteAuth")).getPortRequeteAuth();
		RoleRequeteAuth rra2 = (RoleRequeteAuth) cr.getInterfaceConnecteurComposite("RoleRequeteAuth");
		new RequeteAuth(pra2, rra2);
		
		System.out.println("\n##### Binding Component-Configuration #####");
		
		PortConnexion pc = ((ServiceConnexion) connexionMgr.getInterface("ServiceConnexion")).getPortConnexion();
		PortConnexionServer pcs = (PortConnexionServer) serveurConfig.getInterface("PortConnexionServeur");
		new BindConnexionServeur(pcs, pc);
		
		ConnexionComposantServeur ccs = (ConnexionComposantServeur)(serveurConfig.getInterface("ConnexionComposantServeur"));
		PortConnexionConfigServeur sccs = ((ServiceConnexionConfigServeur) serveurCompo.getInterface("ServiceConnexionConfigServeur")).getPortConnexionConfig();
		new BindServeur(ccs, sccs);
		
		System.out.println("\n##### Execution des methodes glue() #####");
		rpc.glue();
		cr.glue();
		sq.glue();
		sqlq.glue();
		
		System.out.println("\n##### Envois #####");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("   | Class                | Details");
		System.out.println("-----------------------------------------------------------------------------------");
		client.send(new QueryMessage("toto", "tutu", "SELECT * FROM *"));
		System.out.println("-----------------------------------------------------------------------------------");
		
	}
}
