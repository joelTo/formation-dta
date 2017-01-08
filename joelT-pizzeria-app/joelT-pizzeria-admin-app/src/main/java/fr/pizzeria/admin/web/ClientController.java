
package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.ClientServiceEJB;

public class ClientController extends HttpServlet {
	@Inject
	private ClientServiceEJB clientService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listClient", clientService.FindClient());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/client/clientpage.jsp").forward(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
