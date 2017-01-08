package fr.ihm.action;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.dao.IPizzaDaoFactory;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

@Component
public class UpdatePizza extends Action {
	@Autowired
	private Scanner scanner;
	@Autowired
	private IPizzaDaoFactory pizzaDao;

	@PostConstruct
	public void init() {
		this.setDescription("Mettre a jour une pizza");
	}

	@Override
	public void doAction() throws UpdatesPizzaException, SQLException {
		System.out.println("");
		System.out.println("Quelle pizza voulez-vous modifier (donnez son code <Alias>)? ");
		String oldCode = scanner.next();

		System.out.println("Veuillez entrer la modification de l'Alias de votre Pizza");
		String saisieAlias = scanner.next();

		System.out.println("Veuillez entrer la modification  du nom de votre Pizza");
		String saisieNom = scanner.next();

		System.out.println("Veuillez entrer le Categorie de la nouvelle pizza s'il vous plait");
		Stream.of(CategoriePizza.values())
				.forEach(System.out::println); /* Lister les enum cr�� */

		String catPizza = scanner.next();

		System.out.println("Veuillez entrer la modification  du prix de votre Pizza");
		Double saisiePrix = scanner.nextDouble();

		Pizza p = new Pizza(saisieAlias, saisieNom, CategoriePizza.valueOf(catPizza), saisiePrix);
		pizzaDao.update(p, oldCode);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
