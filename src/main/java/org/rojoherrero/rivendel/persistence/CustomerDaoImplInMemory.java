package org.rojoherrero.rivendel.persistence;

import java.util.Collection;

import org.rojoherrero.rivendel.model.entities.Customer;
import org.rojoherrero.rivendel.persistence.memory.CustomerInMemoryDataBase;

public class CustomerDaoImplInMemory implements CustomerDao {

	private CustomerInMemoryDataBase db;

	public CustomerDaoImplInMemory(CustomerInMemoryDataBase db) {
		super();
		this.db = db;
	}

	@Override
	public void registerCustomer(Customer customer) throws Exception {
		db.insertCustomer(customer);
	}

	@Override
	public void removeCustomerById(long id) throws Exception {
		db.removeCustomerById(id);
	}

	@Override
	public void modifyCustomer(Customer customer) throws Exception {
		db.modifyACustomer(customer);
	}

	@Override
	public Customer retriveCustomerById(long id) throws Exception {
		return (db.retrieveCustomerById(id));
	}

	@Override
	public Collection<Customer> retrieveAllCustomers() throws Exception {
		return (db.retrieveAllCustomers());
	}

	@Override
	public Collection<Customer> retrieveCustomersByName(String name) throws Exception {
		return (db.retriveCustomerByName(name));
	}

}
