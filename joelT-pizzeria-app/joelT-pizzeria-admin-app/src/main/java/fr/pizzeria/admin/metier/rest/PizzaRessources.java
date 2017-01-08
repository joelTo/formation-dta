package fr.pizzeria.admin.metier.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.model.Pizza;
import fr.pizzeria.admin.metier.PizzaServiceEJB;

@Path("/pizza")
public class PizzaRessources {
	@Inject
	private PizzaServiceEJB pizzaJPA;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {
		return pizzaJPA.findAllPizza();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPizza(Pizza p) {
		pizzaJPA.save(p);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{oldCode}")
	public void updatePizza(Pizza pizza, @PathParam("oldCode") String oldCode) {
		pizzaJPA.update(pizza, oldCode);
	}

	@DELETE
	@Path("{code}")
	public void deletePizza(@PathParam("code") String code) {
		pizzaJPA.delete(code);
	}
}
