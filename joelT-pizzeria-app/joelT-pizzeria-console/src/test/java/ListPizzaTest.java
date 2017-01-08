import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.ihm.action.ListPizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfig.class)
public class ListPizzaTest {

	@Autowired
	private ListPizza listPizza;

	@Test
	public void test() {
		Assert.assertEquals("Lister les pizzas", listPizza.getDescription());
	}
}
