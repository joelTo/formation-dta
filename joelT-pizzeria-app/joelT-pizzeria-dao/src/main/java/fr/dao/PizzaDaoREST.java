package fr.dao;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

public class PizzaDaoREST implements IPizzaDaoFactory {

	@Override
	public List<Pizza> findAll() throws SQLException {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://localhost:8080/pizzeria-admin-app/api/pizza");
		Builder request = webTarget.request().accept(MediaType.APPLICATION_JSON);
		Response response = request.get();

		List<Pizza> pizzas = response.readEntity(new GenericType<List<Pizza>>() {
		});
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException, SQLException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.example.com/api/customers");
		target.request().post(Entity.entity(newPizza, MediaType.APPLICATION_JSON), Pizza.class);

	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {

	}

	@Override
	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException, SQLException {

	}

}
