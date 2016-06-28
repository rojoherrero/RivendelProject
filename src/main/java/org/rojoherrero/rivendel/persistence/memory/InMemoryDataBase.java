package org.rojoherrero.rivendel.persistence.memory;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.rojoherrero.rivendel.model.entities.Customer;

public class InMemoryDataBase {

	private Map<Long, Customer> customerTable = null;

	public void createTable() {
		customerTable = new HashMap<>();
	}

	public void insertCustomer(Customer customer) {
		customerTable.put(customer.getId(), customer);
	}

	public void removeCustomerById(long id) {
		customerTable.remove(id);
	}

	public void modifyACustomer(Customer customer) {
		this.insertCustomer(customer);
	}
	
	public Customer retrieveCustomerById(long id){
		return(customerTable.get(id));
	}

	public Collection<Customer> retrieveAllCustomer() {
		return (customerTable.values());
	}

	public Collection<Customer> retriveCustomerByName(String name) {
		Collection<Customer> customerMap = customerTable.values();
		Collection<Customer> results = new HashSet<>();
		
		for (Customer customer : customerMap) {
			if (customer.getPersonalInfo().getFirstName().equals(name)) {
				results.add(customer);
			}
		}
		return(results);
	}
}
