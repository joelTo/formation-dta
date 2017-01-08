package fr.ihm;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.ihm.action.Action;
import fr.ihm.action.AddPizza;
import fr.ihm.action.DeletePizza;
import fr.ihm.action.ExitMenu;
import fr.ihm.action.ListPizza;
import fr.ihm.action.ListPizzaGroupeCategorie;
import fr.ihm.action.ListPizzaTarifEleve;
import fr.ihm.action.UpdatePizza;

@Component
public class MainMenu {
	private Map<Integer, Action> map = new TreeMap<Integer, Action>();

	@Autowired
	private Scanner scanner;
	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		// A faire (bonus) Controller a partir du .properties le menu entier.
		map.put(1, context.getBean(ListPizza.class));
		map.put(2, context.getBean(AddPizza.class));
		map.put(3, context.getBean(UpdatePizza.class));
		map.put(4, context.getBean(DeletePizza.class));
		map.put(5, context.getBean(ListPizzaGroupeCategorie.class));
		map.put(6, context.getBean(ListPizzaTarifEleve.class));
		map.put(99, context.getBean(ExitMenu.class));

	}

	public void displayMenu() {
		map.forEach((i, a) -> System.out.println(i + " " + a.getDescription()));
	}

	public void parseAndExec() throws NumberFormatException, SavePizzaException, DeletePizzaException,
			UpdatesPizzaException, SQLException {
		String input = scanner.next();
		this.map.get(Integer.parseInt(input)).doAction();

	}
}
