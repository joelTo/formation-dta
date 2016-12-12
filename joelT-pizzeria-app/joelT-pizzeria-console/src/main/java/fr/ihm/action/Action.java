package fr.ihm.action;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;

/*
 * Classe Abstraite nommée {Action} permettant de rendre commun l'appel du doAction  
 */
public abstract class Action {
	private String description;

	/*
	 * Recupère la description de l'action en question
	 * 
	 * @Return String de l'attribut description
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * Permet d'implémenter l'attribut description de la classe Action
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * Fonction {doAction()} permet de lancer CRUD sur les objets de type pizza
	 * s'il y a des exceptions CRUD, elles vont se referer à leurs classes
	 * Exceptions - SavePizzaException - DeletePizzaException -
	 * UpdatesPizzaException
	 */
	public abstract void doAction() throws SavePizzaException, DeletePizzaException, UpdatesPizzaException;

	/*
	 * Fonction {descriptionAction()} permet de retourner la description de
	 * l'action.
	 */
	public abstract void descriptionAction();
}
