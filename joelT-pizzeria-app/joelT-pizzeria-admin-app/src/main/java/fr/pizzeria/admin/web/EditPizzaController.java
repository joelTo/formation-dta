package fr.pizzeria.admin.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dao.PizzaDaoBaseJPA;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class EditPizzaController extends HttpServlet {
	private PizzaDaoBaseJPA pizzaBaseJPA = new PizzaDaoBaseJPA();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String oldCode = req.getParameter("code");
			Pizza piz = pizzaBaseJPA.findAll().stream().filter(p -> p.getCode().equals(oldCode)).findFirst().get();
			req.setAttribute("PizzaAModifer", piz);
			req.setAttribute("OldCode", oldCode);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editpizza.jsp").forward(req, resp);
		} catch (SQLException e) {
			// renvoyer une page d'erreur
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			pizzaBaseJPA.update(new Pizza(req.getParameter("codePizza"), req.getParameter("libellePizza"),
					CategoriePizza.valueOf(req.getParameter("catPizza")),
					Double.parseDouble(req.getParameter("prixPizza"))), req.getParameter("oldCode"));
			resp.sendRedirect("/pizzeria-admin-app/api/pizza/list");
		} catch (UpdatesPizzaException e) {
			// Afficher un messageerreur
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
