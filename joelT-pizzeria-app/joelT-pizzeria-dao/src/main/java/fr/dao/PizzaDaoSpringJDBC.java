package fr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.exception.DeletePizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

@Repository
public class PizzaDaoSpringJDBC {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoSpringJDBC(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public List<Pizza> findAllPizza() {
		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, new PizzaMapper());
	}

	public void create(Pizza p) {
		String sql = "INSERT INTO PIZZA (id,reference,libelle,prix,catPizza,url) VALUES(?,?,?,?,?,?)";
		this.jdbcTemplate.update(sql, p.getId(), p.getCode(), p.getNom(), p.getPrix(), p.getCatPizza().name(), "null");
	}

	public void update(Pizza p, String oldCode) {
		String sql = "UPDATE PIZZA SET reference = ? ,libelle= ? , prix= ?  WHERE reference = ? ";
		this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(), oldCode);

	}

	public Integer countPizzas() {
		String sql = "SELECT COUNT(*) FROM PIZZA";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public class PizzaMapper implements RowMapper<Pizza> {
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setNom((rs.getString("libelle")));
			p.setCode((rs.getString("reference")));
			p.setCatPizza(CategoriePizza.valueOf((rs.getString("catPizza"))));
			p.setPrix((rs.getDouble("prix")));
			p.setUrl((rs.getString("url")));
			return p;
		}
	}

	public void delete(String pizzaToDelete) throws DeletePizzaException {
		String sql = "DELETE FROM `PIZZA` WHERE `PIZZA`.`reference` = ?";
		this.jdbcTemplate.update(sql, pizzaToDelete);
	}
}
