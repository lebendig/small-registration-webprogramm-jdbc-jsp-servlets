package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoLogin daoLogin = new DaoLogin();

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println(request.getParameter("login"));
//		System.out.println(request.getParameter("password"));

//		BeanUser user = new BeanUser();

//		if (user.valiadte(request.getParameter("login"), request.getParameter("password"))) {
//			
//			RequestDispatcher dispacher = request.getRequestDispatcher("acessoliberado.jsp");
//			dispacher.forward(request, response);
//			
//		} else{
//			RequestDispatcher dispacher = request.getRequestDispatcher("acessonegado.jsp");
//			
//			dispacher.forward(request, response);
//		};

		try {
			if (daoLogin.validateLogin(request.getParameter("login"), request.getParameter("password"))) {

				RequestDispatcher dispacher = request.getRequestDispatcher("acessoliberado.jsp");
				dispacher.forward(request, response);

			} else {
				RequestDispatcher dispacher = request.getRequestDispatcher("acessonegado.jsp");

				dispacher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
