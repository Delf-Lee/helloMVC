package service;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import model.Customer;

@Data
public class CustomerService {
	private Map<String, Customer> customers;

	public CustomerService() {
		customers = new HashMap<String, Customer>();

		addCustomer(new Customer("id001", "Alice", "Alice@hansung.ac.kr"));
		addCustomer(new Customer("id002", "Bob", "Bob@hansung.ac.kr"));
		addCustomer(new Customer("id003", "Charilie", "Charilie@hansung.ac.kr"));
		addCustomer(new Customer("id004", "David", "David@hansung.ac.kr"));
		addCustomer(new Customer("id005", "trudy", "trudy@hansung.ac.kr"));
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);

	}
	
	public Customer findCustoemre(String id) {
		if(id != null) {
			return (customers.get(id.toLowerCase()));
		}
		else {
			return null;
		}
	}
}
