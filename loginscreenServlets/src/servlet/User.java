package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.DaoUser;
import beans.BeanUser;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/saveUser")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoUser daoUser = new DaoUser();
    BeanUser user;    
   
    public User() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	user = new BeanUser();
	user.setLogin(request.getParameter("login"));
	user.setPassword(request.getParameter("password"));
	
	
	//ele vai retrornar para a propria pagina
	daoUser.save(user);
	RequestDispatcher view = request.getRequestDispatcher("/userregistration.jsp");
	
	//passamos a lista de usuarios para a variavel users
	request.setAttribute("users", daoUser.getUsers());
	view.forward(request, response);

	}

}
