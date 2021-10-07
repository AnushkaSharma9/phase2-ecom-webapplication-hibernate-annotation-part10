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
import com.simplilearn.model.ProductDetails;
import com.simplilearn.util.HibernateSessionUtil;


@WebServlet("/add-product-with-details")
public class AddProductWithDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductWithDetails() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-product-with-details.html").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		//product
		String productName = request.getParameter("name");
		String productPrice = request.getParameter("price");
		//product-details
		int  dimention = Integer.parseInt(request.getParameter("dimentions"));
		String description = request.getParameter("description");
		String brand = request.getParameter("brand");
		int weight = Integer.parseInt(request.getParameter("weight"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		
		// build hibernate session factory
		try {
			// 1. load session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create a session
			Session session = factory.openSession();
			
			// 3. create transaction
			 Transaction tx = session.beginTransaction();
			 
			 //4. create product object & product details
			 Product product = new Product(productName, Double.parseDouble(productPrice));
			 ProductDetails details = new ProductDetails(description, dimention, brand, weight, stock);
			 product.setDetails(details);
			 
			 //5. save product
			 session.save(product);
			 
			 //6. commit transaction.
			 tx.commit();

			if (session != null) {
				out.print("<h3 style='color:green'> Product is created with product details sucessfully ! </h3>");
			}

			// close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
		
	}

}