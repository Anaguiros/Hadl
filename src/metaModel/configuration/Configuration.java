package metaModel.configuration;

import java.util.List;

import metaModel.core.Element;

public abstract class Configuration extends Element {

	//Aggrégation d'instance d'Element
	List<Element> listElement;
	//Composition d'interfaces
	List<InterfaceConfiguration> listInterface;

}
