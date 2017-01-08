package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.model.Client;

@Stateless
public class ClientServiceEJB {

	@PersistenceContext(unitName = "joelT-pizzeria-console")
	private EntityManager em;

	public List<Client> FindClient() {
		TypedQuery<Client> empclient = em.createQuery("SELECT p FROM Client p", Client.class);
		return empclient.getResultList();
	}

	public void save(Client newClient) {
		em.persist(newClient);
	}

	public Client findById(Integer numClient) {
		return em.createNamedQuery("id.findById", Client.class).setParameter("id", numClient).getSingleResult();
	}

	public void delete(Integer numClientToDelete) {
		Client pem = findById(numClientToDelete);
		if (findById(numClientToDelete).getId().equals(numClientToDelete)) {
			em.remove(pem);
		}
	}

	public void update(Client ClientUdate, Integer numClient) {
		Client emp = findById(numClient);
		emp.setEmail(ClientUdate.getEmail());
		emp.setName(ClientUdate.getName());
		emp.setLastname(ClientUdate.getLastname());
		emp.setMdp(ClientUdate.getMdp());
		em.persist(emp);
	}

}
