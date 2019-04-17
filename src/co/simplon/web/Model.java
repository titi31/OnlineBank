package co.simplon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import co.simplon.dao.AccountDao;
import co.simplon.dao.Dao;
import co.simplon.dao.UserDao;
import co.simplon.entities.Accounts;
import co.simplon.entities.User;
import co.simplon.metier.BanqueMetier;

/**
 * Servlet implementation class Model
 */
@WebServlet("/model")
public class Model extends HttpServlet {
	private BanqueMetier banqueMetier = null;
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		//Dao.init(this.getServletContext());
		BanqueMetier banqueMetier = new BanqueMetier();
	}


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/vue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("codeCompte");

		BanqueMetier banqueMetier = new BanqueMetier();

		Accounts compte = banqueMetier.consulterAccounts(Integer.parseInt(code));

		if (compte != null) {
			HttpSession session = request.getSession();
			session.setAttribute("codeCompte", compte.getIdCust());
			session.setAttribute("compte", compte);
			//session.setAttribute("balance", compte.getBalance());
			//session.setAttribute("numAccount", compte.getNumCt());
			request.getRequestDispatcher("/vue.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("compte", null);
			session.setAttribute("error", "compte introuvable");
			request.getRequestDispatcher("/vue.jsp").forward(request, response);
		}
	}

}
