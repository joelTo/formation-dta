
package fr.console.action;

import org.jboss.logging.Logger;

import fr.ihm.action.Action;
import fr.ihm.action.IhmUtil;

/*
 * Classe nommée {Exit} qui hérite de la classe {Action} qui est une classe Abstraite permettant l'appel du doAction. 
 * Ici l'action est de sortir.
 */
public class Exit extends Action{
	private IhmUtil ihmUtil;

	public Exit(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("Sortir");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ihm.action.Action#doAction()
	 */
	@Override
	public void doAction() {
		System.exit(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ihm.action.Action#descriptionAction()
	 */
	@Override
	public void descriptionAction() {
		Logger.getLogger(this.getDescription());
	}

}
