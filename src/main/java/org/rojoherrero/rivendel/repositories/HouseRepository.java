package org.rojoherrero.rivendel.repositories;

import java.util.List;

import org.rojoherrero.rivendel.models.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Long> {

	List<House> findAll();

	@Query("SELECT town FROM House h GROUP BY h.town")
	List<String> findTowns();

	@Query("SELECT houseSurface FROM House h")
	List<Double> findHouseSurfaces();

	List<House> findHousesByZipCode(Integer zipCode);

	List<House> findHousesByTown(String town);

	List<House> findHousesByHouseSurface(Double houseSurface);

}
