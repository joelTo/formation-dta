package fr.ihm.action;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;

public abstract class Action {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void doAction() throws SavePizzaException, DeletePizzaException, UpdatesPizzaException;

	public abstract void describeAction();
}
