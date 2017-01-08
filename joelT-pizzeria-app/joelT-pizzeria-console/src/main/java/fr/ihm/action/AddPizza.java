package fr.ihm.action;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.dao.IPizzaDaoFactory;
import fr.exception.SavePizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

@Component // On peut utiliser aussi @Controller qui est un fils de @Component
public class AddPizza extends Action {
	@Autowired
	private Scanner scanner;
	@Autowired
	private IPizzaDaoFactory pizzaDao;

	@PostConstruct
	public void init() {
		this.setDescription("Ajouter une nouvelle pizza");
	}

	@Override
	public void doAction() throws SavePizzaException, SQLException {

		System.out.println("");
		System.out.println("Veuillez entrer l'alias de la nouvelle pizza s'il vous plait");
		String code = scanner.next();
		System.out.println("Veuillez entrer le nom de la nouvelle pizza s'il vous plait");
		String nom = scanner.next();
		System.out.println("Veuillez entrer le Cat�gorie de la nouvelle pizza s'il vous plait");
		Stream.of(CategoriePizza.values())
				.forEach(System.out::println); /* Lister les enum cree */

		String catPizza = scanner.next();

		System.out.println("Veuillez entrer le prix de la nouvelle pizza s'il vous plait");
		Double prix = scanner.nextDouble();

		pizzaDao.save(new Pizza(code, nom, CategoriePizza.valueOf(catPizza), prix));

	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
