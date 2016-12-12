package fr.dao;

import java.util.List;

import fr.exception.BaseJDBCException;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

/*
 * Interface nommée {PizzaDaoFactory}, basé sur le pattern Factory permettant de la mise en place des fonctions CRUD
 * 	- Create : creation d'une pizza
 * 	- Read : Lecture de la liste de pizza
 * 	- Update : Modification d'une pizza
 * 	- Delete : Suppression d'une pizza 
 */
public interface PizzaDaoFactory {

	/*
	 * Fonction correspondant à (Read) : lecture de la liste des pizza
	 */
	List<Pizza> findall() throws BaseJDBCException;

	/*
	 * Fonction correspondant à (Create) : sauver une pizza
	 */
	void save(Pizza newPizza) throws SavePizzaException;

	/*
	 * Fonction correspondant à (Delete) : supprimer d'une pizza
	 */
	void delete(String pizzaToDelete) throws DeletePizzaException;

	/*
	 * Fonction correspondant à (Update) : Mise à jour d'une pizza
	 */
	void update(Pizza pizzaUpdate, String oldCode) throws UpdatesPizzaException;

}
