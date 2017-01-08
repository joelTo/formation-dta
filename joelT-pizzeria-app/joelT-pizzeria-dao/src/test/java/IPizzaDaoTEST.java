import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.dao.PizzaDaoSpringJDBC;
import fr.model.CategoriePizza;
import fr.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDAOTestConfig.class)
public class IPizzaDaoTEST {

	@Autowired
	private PizzaDaoSpringJDBC pizzaDao;

	@Test
	public void test() {
		pizzaDao.create(new Pizza(0, "PEP", "PEPERONI", CategoriePizza.valueOf("VIANDE"), 11));
		Assert.assertEquals((pizzaDao.findAllPizza().stream().filter(x -> "PEP".equals(x.getCode())).findAny().get()),
				new Pizza(0, "PEP", "PEPERONI", CategoriePizza.valueOf("VIANDE"), 11));

	}

	@Test
	public void testcreate() {
		pizzaDao.create(new Pizza(1, "MAT", "MATTIEU", CategoriePizza.VIANDE, 10));

		Assert.assertEquals(pizzaDao.findAllPizza().stream().filter(x -> "MAT".equals(x.getCode())).findAny().get(),
				new Pizza(1, "MAT", "MATTIEU", CategoriePizza.VIANDE, 10));
	}

	@Test
	public void testupdate() {
		pizzaDao.update(new Pizza("MET", "MATTIE2", CategoriePizza.VIANDE, 14), "MAT");
		Assert.assertEquals(pizzaDao.findAllPizza().stream().filter(x -> "MET".equals(x.getCode())).findAny().get(),
				new Pizza("MET", "MATTIE2", CategoriePizza.VIANDE, 14));
	}

}
