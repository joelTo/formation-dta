package fr.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

@Repository
@EnableJpaRepositories("fr.dao")
public class PizzaDaoPizzaRepositoryJPA implements IPizzaDaoFactory {

	@Autowired
	private IPizzaRepository toto;

	@Override
	public List<Pizza> findAll() throws SQLException {
		return toto.findAll();

	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException, SQLException {
		toto.save(newPizza);
	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {

	}

	@Override
	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException, SQLException {
		// TODO Auto-generated method stub

	}

}
