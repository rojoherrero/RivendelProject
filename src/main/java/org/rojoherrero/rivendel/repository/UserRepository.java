package org.rojoherrero.rivendel.repository;

import java.util.Optional;

import org.rojoherrero.rivendel.domain.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Customer, Long> {
	
	Optional<Customer> findOneByEmail(String userEmail);

}
