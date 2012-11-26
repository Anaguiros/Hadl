package model.serveur;

import java.util.ArrayList;
import java.util.Observer;

import metaModel.composant.composite.PortComposantCompositeRequis;
import metaModel.composant.composite.ServiceCompositeRequis;

public class PortConnexionConfigServeur extends PortComposantCompositeRequis {

	private ArrayList<Observer> observers;
	
	public PortConnexionConfigServeur(String name, ServiceCompositeRequis service) {
		super(name, service);
		this.observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer o) {
		super.addObserver(o);
		this.observers.add(o);
	}
	
	public void send(Object object) {
		if (this.countObservers() == 1 && this.observers.get(0).getClass() == ServiceConnexionConfigServeur.class) {
			System.out.println(" x | " + this.getClass().getSimpleName() + " | Arrêt de la propagation de l'objet : aucun binding");
		}
		this.setChanged();
		this.notifyObservers(object);
	}
 
	public void receive(Observer o, Object object) { 
		this.setChanged();
		for (Observer obs : this.observers) {
			if (obs != o) {
				obs.update(this, object);
			}
		}
	}

}
