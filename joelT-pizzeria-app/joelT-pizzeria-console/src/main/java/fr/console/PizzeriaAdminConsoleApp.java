package fr.console;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {

	public static Boolean Arret = false;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, SavePizzaException, DeletePizzaException, UpdatesPizzaException {

		/**
		 * Pour le lancement
		 */
		//
		//
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAppSpringConfig.class)) {
			MainMenu core = context.getBean(MainMenu.class);
			while (true) {
				core.displayMenu();
				core.parseAndExec();
			}
		}

	}
}