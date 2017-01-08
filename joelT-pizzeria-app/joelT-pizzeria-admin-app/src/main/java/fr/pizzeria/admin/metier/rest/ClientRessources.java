
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

import fr.model.Client;
import fr.pizzeria.admin.metier.ClientServiceEJB;

@Path("/clients")
public class ClientRessources {
	@Inject
	private ClientServiceEJB clientJPA;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> list() {
		return clientJPA.FindClient();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createClient(Client p) {
		clientJPA.save(p);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{oldCode}")
	public void updateClient(Client Client, @PathParam("id") Integer id) {
		clientJPA.update(Client, id);
	}

	@DELETE
	@Path("{id}")
	public void deleteClient(@PathParam("id") Integer id) {
		clientJPA.delete(id);
	}
}
