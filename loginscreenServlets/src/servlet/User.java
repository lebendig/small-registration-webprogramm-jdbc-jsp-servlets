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
	user = new BeanUser();
		
		String acao =	request.getParameter("acao");
	    String user =	request.getParameter("user");
	    DaoUser daoUser = new DaoUser();
	

	if (acao.equalsIgnoreCase("delete")) {
		
		//ele vai retrornar para a propria pagina
	   daoUser.delete(user);
	   RequestDispatcher view = request.getRequestDispatcher("/userregistration.jsp");
		
		//passamos a lista de usuarios para a variavel users
		request.setAttribute("users", daoUser.getUsers());
		view.forward(request, response);
		
	}
	
	else if(acao.equalsIgnoreCase("edit")) {
		
		BeanUser userBean = daoUser.getUser(user);

		
		RequestDispatcher view = request.getRequestDispatcher("/userregistration.jsp");
		request.setAttribute("user", userBean);
		view.forward(request, response);
		

		//passamos a lista de usuarios para a variavel users

		
	} else if(acao.equalsIgnoreCase("listall")) {
RequestDispatcher view = request.getRequestDispatcher("/userregistration.jsp");
		
		//passamos a lista de usuarios para a variavel users
		request.setAttribute("users", daoUser.getUsers());
		view.forward(request, response);
	} 
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String acao = request.getParameter("acao");
		if(acao != null && acao.equalsIgnoreCase("reset")) {
			RequestDispatcher view = request.getRequestDispatcher("/userregistration.jsp");
					
					//passamos a lista de usuarios para a variavel users
					request.setAttribute("users", daoUser.getUsers());
					view.forward(request, response);
					
				} else {
		
		String id = request.getParameter("id");
		boolean canSave = true;
		
	user = new BeanUser();
	user.setId(!id.isEmpty()? Long.parseLong(id):null);
	user.setLogin(request.getParameter("login"));
	user.setPassword(request.getParameter("password"));
	user.setName(request.getParameter("name"));
	user.setPhoneNumber(request.getParameter("phoneNumber"));
	
//	setPassword(request.getParameter("password"));
	
	if (id == null || id.isEmpty() && daoUser.hasUser(user.getLogin())) {
		request.setAttribute("msg", "User already exists");
		request.setAttribute("user", user);
		canSave = false;
	}
	
	
	if (request.getParameter("id") == null || request.getParameter("id").isEmpty() && daoUser.hasUser(user.getLogin()) == false && canSave ) {
	//ele vai retrornar para a propria pagina
		
		
	daoUser.save(user);
	
	} else if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
		if (!daoUser.hasUserUpdate(user.getLogin(), String.valueOf(user.getId())) ){
		daoUser.update(user);
		} else {
			request.setAttribute("msg2", "User already exists");
			request.setAttribute("user", user);
		}
	}
	
	
	RequestDispatcher view = request.getRequestDispatcher("/userregistration.jsp");
	
	//passamos a lista de usuarios para a variavel users
	request.setAttribute("users", daoUser.getUsers());
	view.forward(request, response);
	}
	}
}
