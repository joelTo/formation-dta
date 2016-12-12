package fr.ihm.action;

import java.util.Map;
import java.util.TreeMap;

import fr.console.action.Add;
import fr.console.action.Delete;
import fr.console.action.Display;
import fr.console.action.Update;
import fr.exception.ConsoleException;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;

public class MainMenu {
	private Map<Integer, Action> map = new TreeMap<Integer, Action>();
	private IhmUtil ihmUtil;

	public MainMenu(IhmUtil ihmUtil) {

		map.put(1, new Display(ihmUtil));
		map.put(2, new Add(ihmUtil));
		map.put(3, new Update(ihmUtil));
		map.put(4, new Delete(ihmUtil));
		// map.put(99, new ExitMenu());
		this.ihmUtil = ihmUtil;
	}

	public void start() throws ConsoleException {
		displayMenu();
		String input = ihmUtil.getScanner().next();
		try {

			this.map.get(Integer.parseInt(input)).doAction();


		} catch (NumberFormatException e) {
			throw new ConsoleException(e);
		} catch (SavePizzaException e) {
			throw new ConsoleException(e);
		} catch (DeletePizzaException e) {
			throw new ConsoleException(e);
		} catch (UpdatesPizzaException e) {
			throw new ConsoleException(e);
		}

	}
	// *************************************//


	private void displayMenu() {
		map.forEach((i, a) -> System.out.println(i + " " + a.getDescription()));
	}

}
