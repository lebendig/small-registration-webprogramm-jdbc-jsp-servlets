package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import DAO.DaoProduct;
import beans.BeanProduct;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoProduct productDao = new DaoProduct();
 
		String acao = request.getParameter("acao");
		String productId = request.getParameter("productid");
		
		if ( acao.equalsIgnoreCase("listallproducts")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/productregistration.jsp");
			request.setAttribute("products", productDao.getProducts());
			view.forward(request, response);
		} else if (acao.equalsIgnoreCase("delete")) {
			productDao.delete(productId);
			RequestDispatcher view = request.getRequestDispatcher("/productregistration.jsp");
			request.setAttribute("products", productDao.getProducts());
			view.forward(request, response);
		} else if (acao.equalsIgnoreCase("edit")) {
			
			BeanProduct product = productDao.findProductById(productId);
			RequestDispatcher view = request.getRequestDispatcher("/productregistration.jsp");
			request.setAttribute("product", product);
			request.setAttribute("products", productDao.getProducts());	
	
			view.forward(request, response);
			
			
			
			
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoProduct productDao = new DaoProduct();
		String acao = request.getParameter("acao");
		BeanProduct product = new BeanProduct();
		String id = request.getParameter("id");
		

		product.setName(request.getParameter("name"));
		product.setId(!id.isEmpty() ? Long.parseLong(id) : null);
		product.setPrice(request.getParameter("price"));
		product.setQty(request.getParameter("qty"));

		if (product != null && !productDao.hasProduct(product.getName())) {

			productDao.save(product);


		} else if (product != null && productDao.hasProduct(product.getName()) && product.getId() == productDao.findID(product)) {
			productDao.update(product);
		} else {

			// update
			request.setAttribute("msg", "Product already exists");
			request.setAttribute("product", product);
		}

		RequestDispatcher view = request.getRequestDispatcher("/productregistration.jsp");
		request.setAttribute("products", productDao.getProducts());
		view.forward(request, response);
	}

}
