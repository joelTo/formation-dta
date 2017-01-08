package fr.pizzeria.admin.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dao.PizzaDaoBaseJPA;
import fr.exception.DeletePizzaException;

public class DeletePizzaController extends HttpServlet {
	private PizzaDaoBaseJPA pizzaBaseJPA = new PizzaDaoBaseJPA();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		try {
			if (pizzaBaseJPA.findAll().stream().filter(p -> p.getCode().equals(code)).findFirst().isPresent()) {
				try {
					pizzaBaseJPA.delete(code);
					resp.sendRedirect("/pizzeria-admin-app/api/pizza/list");
				} catch (DeletePizzaException e) {
					// Génerer lees pages d'erreurs --> impossible de trouver la
					// pizza dans la base
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// Génerer lees pages d'erreurs --> impossible de trouver la pizza
			// dans interface via la liste
			e.printStackTrace();
		}
	}

}
