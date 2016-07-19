package org.rojoherrero.rivendel.repositories;

import java.util.ArrayList;
import java.util.List;

import org.rojoherrero.rivendel.models.House;
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
	 * Retrieve all the hauses
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
	 * Retrieve all the houses surface
	 * 
	 * @return List<Double>
	 * @author rojoherrero
	 */
	@Query("SELECT houseSurface FROM House h")
	List<Double> findHouseSurfaces();

	/**
	 * Retrieve all the house with the ZipCode zipCode
	 * 
	 * @param zipCode
	 * @return List<House>
	 * @author rojoherrero
	 */
	List<House> findHousesByZipCode(Integer zipCode);

	/**
	 * Retrieve all the houses of the Town town
	 * 
	 * @param town
	 * @return List<House>
	 * @author rojoherrero
	 */
	ArrayList<House> findHousesByTown(String town);

	/**
	 * Retrieve all the houses with the HouseSurface houseSurface
	 * 
	 * @param houseSurface
	 * @return List<House>
	 * @author rojoherrero
	 */
	List<House> findHousesByHouseSurface(Double houseSurface);

}
