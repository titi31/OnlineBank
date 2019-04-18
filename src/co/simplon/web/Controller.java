package co.simplon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.simplon.dao.Dao;
import co.simplon.dao.UserDao;
import co.simplon.entities.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		Dao.init(this.getServletContext());
	}

	public Controller() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)			throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		if (login == null)				login = "";
		if (password == null)			password = "";
		
		request.setAttribute("login", login);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)			throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		UserDao userDao = new UserDao();

		User user = userDao.isValidLogin(login, password);
		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("compte", null);
			session.setAttribute("listOperations", null);
			session.setAttribute("ConnectedUser", user);
			session.setAttribute("login", login);
			request.getRequestDispatcher("/vue.jsp").forward(request, response);

		} else
			request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
