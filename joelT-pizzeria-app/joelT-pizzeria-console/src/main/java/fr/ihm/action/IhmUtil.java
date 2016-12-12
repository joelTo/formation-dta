package fr.ihm.action;

import java.util.Scanner;

import org.jboss.logging.Logger;

import fr.dao.PizzaDaoFactory;

/*
 * Class IhmUtil a pour mission de creer une unique instance des objets suivants:
 * 	- Scanner --> Permettant la récupération de saisie sur le clavier
 * 	- PizzaDaoFactory --> Permet la manipulation d'action sur les objets Pizza peu importe les sources  
 */
public class IhmUtil {
	private Scanner scanner;
	private PizzaDaoFactory pizzaDao;
	private Logger logger = Logger.getLogger(IhmUtil.class);

	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao, Logger logger) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
		this.logger = logger;
	}

	/*
	 * Appel le getteur de Scanner
	 * 
	 * @return retourne l'objet scanner
	 */
	public Scanner getScanner() {
		return this.scanner;
	}

	/*
	 * Appel le getteur de PizzaDao
	 * 
	 * @return retourne l'objet Doa de pizza
	 */
	public PizzaDaoFactory getPizzaDao() {
		return this.pizzaDao;
	}

}
