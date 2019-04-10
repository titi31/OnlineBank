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
		Dao.init( this.getServletContext() );
	}
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String login = request.getParameter( "txtLogin" );
         String password = request.getParameter( "txtPassword" );
         if ( login == null ) login = "";
         if ( password == null ) password = "";
         //recuperer
         HttpSession session = request.getSession( true );
         session.setAttribute( "login", login );
         session.setAttribute( "password", password );
         
       //  request.getRequestDispatcher( "/vue.jsp" ).forward( request, response );

         response.setContentType( "text/html" );
         request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login=request.getParameter("txtLogin");
		String password=request.getParameter("txtPassword");
		UserDao cd1=new UserDao();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User c1=new User(login,password);
		
		if(cd1.isConnected(c1.getNameUser(), c1.getPasswordUser())!=null) {
			out.println("ok");
		}else
			doGet(request, response);
	}

}
