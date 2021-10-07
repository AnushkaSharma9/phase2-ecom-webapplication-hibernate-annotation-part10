package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.Order;
import com.simplilearn.model.Payment;
import com.simplilearn.model.Product;
import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/add-products-with-payments")
public class AddPrductsWithPayments extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public AddPrductsWithPayments() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-products-with-payments.html").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);

		// get product details
		String productName = request.getParameter("name");
		double productPrice = Double.parseDouble(request.getParameter("price"));

		// get payment details
		String customerName1 = request.getParameter("customerName1");
		double price1 = Double.parseDouble(request.getParameter("price1"));
		
		String customerName2 = request.getParameter("customerName2");
		double price2 = Double.parseDouble(request.getParameter("price2"));


		// build hibernate session factory
		try {
			// 1. load session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create a session
			Session session = factory.openSession();

			// 3. create transaction
			Transaction tx = session.beginTransaction();

			// create product object
			Product product = new Product(productName, productPrice);
			
			//create payments set
			Payment paymentOne = new Payment(customerName1, price1);
			Payment paymentTwo = new Payment(customerName2, price2);
			Set<Payment> payments = new HashSet<>();
			
			payments.add(paymentOne);
			payments.add(paymentTwo);
			
			//set payments to product
			product.setPayments(payments);
			
			// 5. save product
			session.save(product);

			// 6. commit transaction.
			tx.commit();

			if (session != null) {
				out.print("<h3 style='color:green'> Products are created with payments sucessfully ! </h3>");
			}

			// close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>"+e);
		}

	}

}