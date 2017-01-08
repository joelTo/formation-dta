import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.dao.PizzaDaoPizzaRepositoryJPA;
import fr.exception.SavePizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDAOTestConfig.class)
public class PizzaDaoEntityUseJPATEST {
	@Inject
	private PizzaDaoPizzaRepositoryJPA pizzaDao;

	@Test
	public void test() {
		try {
			pizzaDao.save(new Pizza("PEP", "PEPERONI", CategoriePizza.valueOf("VIANDE"), 11.2, "test_url"));
		} catch (SavePizzaException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Assert.assertEquals((pizzaDao.findAll().stream().filter(x -> "PEP".equals(x.getCode())).findAny().get()),
					new Pizza(1, "PEP", "PEPERONI", CategoriePizza.valueOf("VIANDE"), 11.2, "test_url"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
