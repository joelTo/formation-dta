package fr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.model.Pizza;

@Transactional
@Repository
public class PizzaDaoEntityUseJPA {

	@PersistenceContext
	private EntityManager em;

	public List<Pizza> findAll() {
		TypedQuery<Pizza> empizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		return empizza.getResultList();
	}

	public void save(Pizza newPizza) {
		em.persist(newPizza);
	}

	public Pizza findByCode(String codePizza) {
		return em.createNamedQuery("code.findByCode", Pizza.class).setParameter("name", codePizza).getSingleResult();
	}

	public void delete(String pizzaToDelete) {
		Pizza pem = findByCode(pizzaToDelete);
		if (findByCode(pizzaToDelete).getCode().equals(pizzaToDelete)) {
			em.remove(pem);
		}
	}

	public void update(Pizza pizzaUdate, String oldCode) {
		Pizza emp = findByCode(oldCode);
		emp.setCode(pizzaUdate.getCode());
		emp.setNom(pizzaUdate.getNom());
		emp.setPrix(pizzaUdate.getPrix());
		emp.setCatPizza(pizzaUdate.getCatPizza());
		emp.setUrl(pizzaUdate.getUrl());
		em.persist(emp);
	}
}
