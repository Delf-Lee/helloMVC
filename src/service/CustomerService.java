package service;

import java.util.HashMap;
import java.util.Map;

import lombok.experimental.PackagePrivate;
import model.Customer;

// 두로긴 두레지스터에서 둘다 접근함
// 객체 하나 싱글톤
public class CustomerService {
	private Map<String, Customer> customers;

	/* about singleton */
	private static final CustomerService instance = new CustomerService();

	public CustomerService() {
		customers = new HashMap<String, Customer>();
		inputTestData();
	}

	/** @return the singleton instance of CustomerService */
	public static CustomerService getInstance() {
		return instance;
	}

	/** @param customer a customer add to the database(hashMap) */
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	/** input the data for debuging. */
	private void inputTestData() {
		addCustomer(new Customer("id001", "id001", "Alice", "female", "Alice@hansung.ac.kr"));
		addCustomer(new Customer("id002", "id002,", "Bob", "male", "Bob@hansung.ac.kr"));
		addCustomer(new Customer("id003", "id003", "Charilie", "female", "Charilie@hansung.ac.kr"));
		addCustomer(new Customer("id004", "id004", "David", "male", "David@hansung.ac.kr"));
		addCustomer(new Customer("id005", "id005", "trudy", "female", "trudy@hansung.ac.kr"));
	}

	/**  confirm login data and decide whether or not to permit to access. 
	 * @param id the costomers's id.
	 * @param password the password following id. 
	 * @return if exist customer in database and password is correct, return the instance of that customer. if not null. */
	public Customer login(String id, String password) {
		Customer guest = customers.get(id); // get Customer object about id
		if (guest != null && !guest.isPasswordCorrect(password)) { // confirm password. if not correct, return null. 
			return null;
		}
		return guest;
	}
}
