package fr.ihm.action;

import java.sql.SQLException;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.dao.IPizzaDaoFactory;
import fr.exception.DeletePizzaException;

@Component
public class DeletePizza extends Action {
	@Autowired
	private Scanner scanner;
	@Autowired
	private IPizzaDaoFactory pizzaDao;

	@PostConstruct
	public void init() {
		this.setDescription("Supprimer une pizza");
	}

	@Override
	public void doAction() throws DeletePizzaException, SQLException {
		System.out.println("");
		System.out.println("Veuillez entrerle code <Alias de pizza a supprimer, s'il vous plait");
		String pizzaToDelete = scanner.next();
		pizzaDao.delete(pizzaToDelete);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
