package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");

		// Perfoorm business logic. Return a bean as a result.
		CustomerService service = new CustomerService();
		Customer customer = service.findCustoemre(customerId);
		
		request.setAttribute("customer", customer);
		
		// We can itrate over lists using forEach in JSTL
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("id006", "Kim", "Kim@hasung.ac.kr"));
		customers.add(new Customer("id006", "Lee", "Lee@hasung.ac.kr"));
		customers.add(new Customer("id006", "Park", "Park@hasung.ac.kr"));
		request.setAttribute("customerList", customers);
		

		String page;
		if (customer == null) {
			page = "/view/error.jsp";
		}
		else {
			page = "/view/success.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); // Æ÷¿öµù
		dispatcher.forward(request, response);
	}
}
