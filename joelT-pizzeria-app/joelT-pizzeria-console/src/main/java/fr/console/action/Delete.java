package fr.console.action;

import org.jboss.logging.Logger;

import fr.exception.DeletePizzaException;
import fr.ihm.action.Action;
import fr.ihm.action.IhmUtil;

/*
 * Classe nommée {Delete} qui hérite de la classe {Action} qui est une classe Abstraite permettant l'appel du doAction. 
 * Ici l'action est de supprimer l'objet pizza
 */
public class Delete extends Action {
	private IhmUtil ihmUtil;

	public Delete(IhmUtil ihmUtil) {
		super();
		this.setDescription("Supprimer une pizza");
		this.ihmUtil = ihmUtil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.console.action.Action#doAction()
	 */
	@Override
	public void doAction() throws DeletePizzaException {
		System.out.println("");
		System.out.println("Veuillez entrerle code <Alias de pizza a supprimer, s'il vous plait");
		String pizzaToDelete = ihmUtil.getScanner().next();
		ihmUtil.getPizzaDao().delete(pizzaToDelete);

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
