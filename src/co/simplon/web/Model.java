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
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		Dao.init( this.getServletContext() );
	}  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Model() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String login = request.getParameter( "txtLogin" );
         String password = request.getParameter( "txtPassword" );
         HttpSession session = request.getSession( true );
         session.setAttribute( "login", login );
         session.setAttribute( "pass", password );
   
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		  request.getRequestDispatcher("/comptes.html").forward(request, response);
		/*out.println("<html>");
		out.println("<head>");
		out.println("<title>compte</title><meta charset='utf-8'>");
		out.println(" <link rel='stylesheet' type='text/css' href='styles.css' />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Bonjour "+login+"</h1>");
		out.println("<form action='model' method='post'>");
		out.println("<input name='txtLogin'  type='hidden' value='"+login+"'>");
		out.println("<input name='txtPassword' type='hidden' value='"+password+"'>");
		out.println("<div id='blockc'><h2 id='consul'>Consultation d'un compte</h2>");
		out.println("<label>Code Compte</label><input name='code' type='number'>");
		out.println("<input type='submit' value='ok' class='bouton' ></div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String login = request.getParameter( "txtLogin" );
         String password = request.getParameter( "txtPassword" );
         String code=request.getParameter("codeCompte");
         
         
         UserDao cd1=new UserDao();
         AccountDao cd=new AccountDao();
 		response.setContentType("text/html");
 		PrintWriter out=response.getWriter();
 		User c1=new User(login,password);
 		 HttpSession session = request.getSession( true );
 		 
 		 //je dois utiliser banqueMetier
		
 		 BanqueMetier banqueMetier = new BanqueMetier();
		  
		  Accounts compte = banqueMetier.consulterAccounts(10);
		  
		//  banqueMetier.listOperations(compte.get)
		 
 		 
 		request.getRequestDispatcher("/comptes.html").forward(request, response);
 		 
 		/*if(cd.afficheC(Integer.parseInt(code),login)!=null) {
 			doGet(request, response);
 			//out.println("<div id='blocki'><h2 id='info'>Informations sur le compte</h2>");
 		//	out.println(cd.find(Integer.parseInt(code)));
 			//out.println("</div>");
 			session.setAttribute("codeCompte","");
 			
 		}else {
 			doGet(request, response);
 			out.println("<div id='blocki'><h2 id='info'>Informations sur le compte</h2>");
 			out.println("compte introuvable");
 			out.println("</div>");
 			
 		}*/
	}

}
