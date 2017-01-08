package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthAdminController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/connect.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("textinput").equals("admin") && req.getParameter("passwordinput").equals("admin")) {
			System.out.println("Je suis entrez dans le POST --> AuthAminController");
			// Mettre en mode session active
			HttpSession userSession = req.getSession();
			userSession.setAttribute("name", req.getParameter("textinput"));
			userSession.setAttribute("mdp", req.getParameter("passwordinput"));
			resp.sendRedirect("/pizzeria-admin-app/api/pizza/list");

		}
	}

}
