package fr.console.action;

import java.util.stream.Stream;

import org.jboss.logging.Logger;

import fr.exception.SavePizzaException;
import fr.ihm.action.Action;
import fr.ihm.action.IhmUtil;
import fr.model.CategoriePizza;
import fr.model.Pizza;

/*
 * Classe nommée {Add} qui hérite de la classe {Action} qui est une classe Abstraite permettant l'appel du doAction. 
 * Ici l'action est de ajouter l'objet pizza
 */
public class Add extends Action {
	private IhmUtil ihmUtil;

	public Add(IhmUtil ihmUtil) {
		super();
		this.setDescription("Ajouter une nouvelle pizza");
		this.ihmUtil = ihmUtil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.console.action.Action#doAction()
	 */
	@Override
	public void doAction() throws SavePizzaException {
		Logger.getLogger(Add.class.getName()).info("Veuillez entrer l'alias de la nouvelle pizza s'il vous plait");
		// System.out.println("Veuillez entrer l'alias de la nouvelle pizza s'il
		// vous plait");
		String code = ihmUtil.getScanner().next();
		Logger.getLogger(Add.class.getName()).info("Veuillez entrer le nom de la nouvelle pizza s'il vous plait");
		// System.out.println("Veuillez entrer le nom de la nouvelle pizza s'il
		// vous plait");
		String nom = ihmUtil.getScanner().next();
		Logger.getLogger(Add.class.getName()).info("Veuillez entrer le Cat�gorie de la nouvelle pizza s'il vous plait");
		// System.out.println("Veuillez entrer le Cat�gorie de la nouvelle pizza
		// s'il vous plait");
		Stream.of(CategoriePizza.values())
				.forEach(System.out::println); /* Lister les enum cree */

		String catPizza = ihmUtil.getScanner().next();

		//System.out.println("Veuillez entrer le prix de la nouvelle pizza s'il vous plait");
		
		Double prix = ihmUtil.getScanner().nextDouble();

		ihmUtil.getPizzaDao().save(new Pizza(code, nom, CategoriePizza.valueOf(catPizza), prix));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.console.action.Action#descriptionAction()
	 */
	@Override
	public void descriptionAction() {
		Logger.getLogger(this.getDescription());
	}

}
