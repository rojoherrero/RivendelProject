package org.rojoherrero.rivendel.models;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HouseDao extends CrudRepository<House, Long> {

	List<House> findAll();

	@Query("SELECT town FROM House h")
	List<String> findTowns();
	
	List<House> findByZipCode(Integer zipCode);
	List<House> findByTown(String town);
	List<House> findByHouseSurface(Double houseSurface);

}
