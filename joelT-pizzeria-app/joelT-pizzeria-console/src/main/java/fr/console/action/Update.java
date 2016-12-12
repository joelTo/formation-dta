package fr.console.action;

import org.jboss.logging.Logger;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.ihm.action.Action;
import fr.ihm.action.IhmUtil;

/*
 * Classe nommée {Update} qui hérite de la classe {Action} qui est une classe Abstraite permettant l'appel du doAction. 
 * Ici l'action est de updater l'objet pizza
 */
public class Update extends Action {
	private IhmUtil ihmutil;

	public Update(IhmUtil ihmutil) {
		super();
		this.setDescription("Mettre a jour une pizza");
		this.ihmutil = ihmutil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.console.action.Action#doAction()
	 */
	@Override
	public void doAction() throws SavePizzaException, DeletePizzaException, UpdatesPizzaException {


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
