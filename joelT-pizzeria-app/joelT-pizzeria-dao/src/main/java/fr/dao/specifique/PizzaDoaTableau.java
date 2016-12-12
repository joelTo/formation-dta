package fr.dao.specifique;

import java.util.ArrayList;
import java.util.List;

import fr.dao.PizzaDaoFactory;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class PizzaDoaTableau implements PizzaDaoFactory {
	private List<Pizza> pizzas = new ArrayList<Pizza>() {
		{
			add(new Pizza(0, "PEP", "Pépéroni", CategoriePizza.VIANDE, 12.50));
			add(new Pizza(1, "MAR", "Margherita", CategoriePizza.VIANDE, 14.00));
			add(new Pizza(2, "REI", "La Reine", CategoriePizza.VIANDE, 11.50));
			add(new Pizza(3, "FRO", "La 4 fromages", CategoriePizza.SANS_VIANDE, 12.00));
			add(new Pizza(4, "CAN", "La cannibale", CategoriePizza.VIANDE, 12.50));
			add(new Pizza(5, "SAV", "La savoyarde", CategoriePizza.VIANDE, 13.00));
			add(new Pizza(6, "IND", "L’indienne", CategoriePizza.POISSON, 14.00));
			add(new Pizza(7, "ORI", "L’orientale", CategoriePizza.VIANDE, 13.50));
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.dao.PizzaDaoFactory#findall()
	 */
	@Override
	public List<Pizza> findall() {
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		if (isValid(newPizza)) {
			throw new SavePizzaException();
		}
		pizzas.add(new Pizza(pizzas.size(), newPizza.getCode(), newPizza.getNom(), newPizza.getCatPizza(),
				newPizza.getPrix()));
	}


	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		if (codeIsValide(pizzaToDelete)) {
			throw new DeletePizzaException();
		}
		Pizza piz = pizzas.stream().filter(p -> p.getCode().equals(pizzaToDelete)).findFirst().get();
		pizzas.remove(piz);
	}


	@Override
	public void update(Pizza pizzaUpdate, String oldCode) throws UpdatesPizzaException {
		if (isExisting(pizzaUpdate, oldCode)) {
			throw new UpdatesPizzaException();
		}
		Pizza piz = pizzas.stream().filter(p -> p.getCode().equals(oldCode)).findFirst().get();
		Pizza pizzaModifiee = new Pizza(piz.getId(), pizzaUpdate.getCode(), pizzaUpdate.getNom(),
				pizzaUpdate.getCatPizza(), pizzaUpdate.getPrix());
		pizzas.set(piz.getId(), pizzaModifiee);

	}


	// *******************************************************************************//
	private boolean isValid(Pizza newPizza) {
		return newPizza.getCode().isEmpty() && newPizza.getNom().isEmpty() && newPizza.getPrix() != 0;
	}

	private boolean codeIsValide(String pizzaToDelete) {
		return !pizzas.stream().filter(p -> p.getCode().equals(pizzaToDelete)).findFirst().isPresent();
	}

	private boolean isExisting(Pizza pizzaUpdate, String oldCode) {
		if (pizzas.stream().filter(p -> p.getCode().equals(oldCode)).findFirst().isPresent()) {
			/*
			 * mise en place du logger à faire
			 * LOG.("Probleme le code entrez n'existe pas ")
			 */
			return false;
		}
		return (pizzaUpdate.getCode().isEmpty() && pizzaUpdate.getNom().isEmpty() && pizzaUpdate.getPrix() != 0);
	}

}
