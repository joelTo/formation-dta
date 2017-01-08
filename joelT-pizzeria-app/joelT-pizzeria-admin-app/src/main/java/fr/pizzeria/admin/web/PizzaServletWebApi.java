package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dao.PizzaDaoBaseJPA;
import fr.model.Pizza;

public class PizzaServletWebApi extends HttpServlet {
	private PizzaDaoBaseJPA pizzaBaseJPA = new PizzaDaoBaseJPA();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pizza> pizzas = null;
		try {
			pizzas = pizzaBaseJPA.findAll();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		PrintWriter writer = resp.getWriter();
		writer.write((pizzas.toString()));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

}
