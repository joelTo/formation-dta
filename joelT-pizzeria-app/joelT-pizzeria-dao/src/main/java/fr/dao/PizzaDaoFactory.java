package fr.dao;

import java.io.IOException;
import java.util.ArrayList;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

public interface PizzaDaoFactory {

	ArrayList<Pizza> findAll();

	void save(Pizza newPizza) throws SavePizzaException, IOException;

	void delete(String pizzaToDelete) throws DeletePizzaException;

	void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException;

}
