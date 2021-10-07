package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.Product;
import com.simplilearn.util.HibernateSessionUtil;



/**
 * Servlet implementation class InitSession
 */
@WebServlet("/update-product")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProduct() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("update-product.html").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		String productId = request.getParameter("id");
		String productName = request.getParameter("name");
		String productPrice = request.getParameter("price");
		// build hibernate session factory
		try {
			// 1. load session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create a session
			Session session = factory.openSession();
			
			// 3. create transaction
			 Transaction tx = session.beginTransaction();
			 
			 //4. create product object
			 Product product = new Product(Integer.parseInt(productId), productName, Double.parseDouble(productPrice));
			 
			 //5. update product
			 session.update(product);
			 
			 //6. commit transaction.
			 tx.commit();

			if (session != null) {
				out.print("<h3 style='color:green'> Product is update sucessfully ! </h3>");
			}

			// close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}

}