package model.core;

import model.serveur.ConnexionComposantServeur;
import model.serveur.PortReceptionServeur;

public class BindConnexionServeur {

	private ConnexionComposantServeur connexionComposant;
	private PortReceptionServeur portReception;
	
	public BindConnexionServeur(ConnexionComposantServeur connexionComposant, PortReceptionServeur portReception) {
		this.connexionComposant = connexionComposant;
		this.portReception = portReception;
	}

}
