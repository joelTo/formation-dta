package fr.dao.specifique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import fr.dao.PizzaDaoFactory;
import fr.exception.BaseJDBCException;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class PizzaDaoBaseJDBC implements PizzaDaoFactory {

	@FunctionalInterface
	interface IRunSql<T> {
		T exec(Statement st) throws SQLException;
	}

	@FunctionalInterface
	interface IRunSqlPrep<T> {
		T execPrep(Connection conn) throws SQLException;
	}

	public <T> T execute(IRunSql<T> run) throws BaseJDBCException {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String jdbcUrl = bundle.getString("jdbc.url");
		String jdbcUser = bundle.getString("jdbc.user");
		String jdbcPass = bundle.getString("jdbc.pass");

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
				Statement statement = con.createStatement();) {

			return run.exec(statement);

		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoBaseJDBC.class.getName()).severe(e.getMessage());
			throw new BaseJDBCException(e);
		}

	}

	public <T> T executePrep(IRunSqlPrep<T> run) throws BaseJDBCException {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String jdbcUrl = bundle.getString("jdbc.url");
		String jdbcUser = bundle.getString("jdbc.user");
		String jdbcPass = bundle.getString("jdbc.pass");

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);) {

			return run.execPrep(con);

		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoBaseJDBC.class.getName()).severe(e.getMessage());
			throw new BaseJDBCException(e);
		}

	}
	@Override
	public List<Pizza> findall() throws BaseJDBCException {
		return execute((Statement statement) -> {
			List<Pizza> pizzas = new ArrayList<>();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM PIZZA");
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String code = resultSet.getString("code");
				String nom = resultSet.getString("nom");
				Double prix = resultSet.getDouble("prix");
				String categorie = resultSet.getString("categoriePizza");
				pizzas.add(new Pizza(id, code, nom, CategoriePizza.valueOf(categorie), prix));
			}
			return pizzas;
		});
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		// executePrep((Connection con) -> {
		// PreparedStatement insertPizza = con
		// .prepareStatement("INSERT INTO PIZZA(code,nom,prix,categoriePizza)
		// VALUES(?,?,?,?)");
		// insertPizza.setString(1, newPizza.getCode());
		// insertPizza.setString(2, newPizza.getNom());
		// insertPizza.setDouble(3, newPizza.getPrix());
		// insertPizza.setString(4, newPizza.getCatPizza().toString());
		// insertPizza.execute();
		// return null;
		// });

	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		// int idPizza = id;
		// executePrep((Connection connection) -> {
		// PreparedStatement deletePizzaSt = connection.prepareStatement("DELETE
		// FROM PIZZA WHERE ID = ?");
		// deletePizzaSt.setInt(1, idPizza);
		// deletePizzaSt.executeUpdate();
		// return Void.TYPE;
		// });

	}

	@Override
	public void update(Pizza pizzaUpdate, String oldCode) throws UpdatesPizzaException {
		// int idPizza = id;
		// executePrep((Connection con) -> {
		// PreparedStatement updatePizza = con
		// .prepareStatement("UPDATE PIZZA SET code=?, nom=?, prix=?,
		// categoriePizza=? WHERE ID=?");
		// updatePizza.setString(1, p.getCode());
		// updatePizza.setString(2, p.getNom());
		// updatePizza.setDouble(3, p.getPrix());
		// updatePizza.setString(4,
		// p.getCategoriePizza().getValue().toString());
		// updatePizza.setInt(5, idPizza);
		//
		// updatePizza.executeUpdate();
		// return null;
		// });

	}

}
