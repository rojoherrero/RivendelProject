package org.rojoherrero.rivendel.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.rojoherrero.rivendel.models.House;
import org.springframework.data.jpa.repository.Modifying;
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
	 * Retrieve all the houses surface
	 * 
	 * @return List<Double>
	 * @author rojoherrero
	 */
	@Query("SELECT houseSurface FROM House h")
	List<Double> findHouseSurfaces();

	/**
	 * Update the data for houses entities
	 * 
	 * @param quarter
	 * @param streetName
	 * @param streetNumber
	 * @param zipCode
	 * @param town
	 * @param country
	 * @param houseSurface
	 * @param gardenSurface
	 * @param totalSurface
	 * @param modificationDate
	 * @param id
	 * @author rojoherrero
	 */
	@Modifying
	@Query("UPDATE House h SET h.quarter = ?1, h.streetName = ?2, h.streetNumber = ?3, "
			+ "h.zipCode = ?4, h.town = ?5, h.country = ?6, h.houseSurface = ?7,"
			+ "h.gardenSurface = ?8, h.totalSurface = ?9, h.modificationDate = ?10 WHERE h.id = ?11")
	void upDateHouseData(String quarter/* 1 */, String streetName/* 2 */, Integer streetNumber/* 3 */,
			Integer zipCode/* 4 */, String town /* 5 */, String country /* 6 */, Double houseSurface/* 7 */,
			Double gardenSurface/* 8 */, Double totalSurface/* 9 */, Calendar modificationDate/* 10 */,
			Long id/* 11 */);
	/* Numbers after parameters are to help me to build the update query */

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
