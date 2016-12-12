import java.util.Scanner;

import fr.dao.specifique.PizzaDoaTableau;
import fr.exception.ConsoleException;
import fr.ihm.action.IhmUtil;
import fr.ihm.action.MainMenu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws ConsoleException {
		/*
		 * {ResourceBundle bundle = ResourceBundle.getBundle("application");}
		 * Récuperation de la configuration dans le dossier Resource->
		 * application.properties
		 * 
		 */
		
		
		
		// PizzaDaoFactory doaFactory;
		// ResourceBundle bunble = ResourceBundle.getBundle(
		// "application");/* recuperation dans le dossier application */
		// String doaConfig = bunble.getString(
		// "dao.impl"); /* recuperation de l'attribut stocker en String */
		//
		// try {
		// doaFactory = (PizzaDaoFactory) Class.forName(doaConfig)
		// .newInstance(); /*
		// * creation de la classe nommée par
		// * l'attribut stocker dans doaConfig
		// */
		//
		// } catch (InstantiationException | IllegalAccessException |
		// ClassNotFoundException e) {
		// throw new ConsoleException(e);
		//
		// }

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDoaTableau());
		MainMenu menu = new MainMenu(ihmUtil);
		menu.start();
	}
}


