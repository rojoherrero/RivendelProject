package org.rojoherrero.rivendel.repositories;

import java.util.List;
import java.util.Map;

import org.rojoherrero.rivendel.models.entities.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository to access House entity
 * 
 * @author rojoherrero
 *
 */
public interface HouseRepository extends CrudRepository<House, Long> {

	/**
	 * Retrieve all the houses
	 * 
	 * @return List<House>
	 * @author rojoherrero
	 */
	List<House> findAll();

	/**
	 * Retrieve the list of town group by towns
	 * 
	 * @return List<String>
	 * @author rojoherrero
	 */
	@Query("SELECT town FROM House h GROUP BY h.town")
	List<String> findTowns();

	/**
	 * Retrieve all the houses of the Town town
	 * 
	 * @param town
	 * @return List<House>
	 * @author rojoherrero
	 */
	List<House> findHousesByTown(String town);
	
	@Query("SELECT town, COUNT(town) FROM House h GROUP BY h.town")
	Map<String, Integer> findNumberOfHousesByTown();

}
