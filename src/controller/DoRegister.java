package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;
/**
 * this servlet processes the request of registerForm. And add the information that created based on request data.
 * */
@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoRegister() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get request information.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		// create customer instance and add this to database.
		CustomerService service = CustomerService.getInstance();
		Customer customer = new Customer(id, password, name, gender, email);
		service.addCustomer(customer);
		request.setAttribute("customer", customer);
		
		// send appropriate response to client.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/registerSuccess.jsp"); // forwarding
		dispatcher.forward(request, response);
	}

}
