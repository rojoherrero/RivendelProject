package org.rojoherrero.rivendel.repositories;

import java.util.Optional;

import org.rojoherrero.rivendel.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findOneByEmail(String email);

}
