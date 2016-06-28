package org.rojoherrero.rivendel.persistence;

import java.util.Collection;

import org.rojoherrero.rivendel.model.entities.Customer;

public interface CustomerDao {

	void registerCustomer(Customer customer) throws Exception;
	void removeCustomerById(long id) throws Exception;
	void modifyCustomer(Customer customer) throws Exception; 
	Customer retriveCustomerById(long id) throws Exception;
	Collection<Customer> retrieveAllCustomers() throws Exception;
	Collection<Customer> retrieveCustomersByName(String Name) throws Exception;
	
}
