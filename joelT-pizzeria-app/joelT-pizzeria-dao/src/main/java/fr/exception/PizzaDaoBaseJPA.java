package fr.exception;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import fr.dao.PizzaDaoFactory;
import fr.model.Pizza;

public class PizzaDaoBaseJPA implements PizzaDaoFactory {
	private EntityManagerFactory emf;
	@PersistenceUnit(unitName = "joelT-pizzeria-console")
	private EntityManager em;

	@Override
	public List<Pizza> findall() throws BaseJDBCException {
			em = emf.createEntityManager();
			TypedQuery<Pizza> empizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
			return empizza.getResultList();
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(newPizza);
		et.commit();
		em.close();

	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		Pizza emp = findByCode(pizzaToDelete);
		System.out.println("La " + emp + "va être modifié");

		if (emp != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(emp);
			et.commit();
			em.close();
		}
	}

	@Override
	public void update(Pizza pizzaUpdate, String oldCode) throws UpdatesPizzaException {
		Pizza emp = findByCode(oldCode);
		if (emp != null) {
			EntityTransaction et = em.getTransaction();
			System.out.println("On est passe par iuci");
			et.begin();
			em.persist(pizzaUpdate);
			et.commit();
			em.close();
		}
	}

	public PizzaDaoBaseJPA() {
		this.emf = Persistence.createEntityManagerFactory("joelT-pizzeria-console");
	}

	public Pizza findByCode(String codePizza) {
		return em.createNamedQuery("code.findByCode", Pizza.class).setParameter("name", codePizza).getSingleResult();
	}

}
