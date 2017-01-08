package fr.pizzeria.admin.metier;

import java.util.List;

import javax.inject.Inject;

import fr.model.Pizza;

public class PizzaService {
	@Inject
	private PizzaServiceEJB pizzaJPA;

	List<Pizza> findAll() {
		return pizzaJPA.findAllPizza();
	}
}
