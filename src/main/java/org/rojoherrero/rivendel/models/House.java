package org.rojoherrero.rivendel.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * House entity
 * 
 * @author rojoherrero
 *
 */
@Entity
@Table(name = "houses")
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String quarter;
	@NotNull
	private String streetName;
	@NotNull
	private Integer streetNumber;
	@NotNull
	private Integer zipCode;
	@NotNull
	private String town;
	@NotNull
	private String country;
	@NotNull
	private Double houseSurface;

	private Double gardenSurface;
	@NotNull
	private Double totalSurface;

	@NotNull
	private Calendar registrationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getHouseSurface() {
		return houseSurface;
	}

	public void setHouseSurface(Double houseSurface) {
		this.houseSurface = houseSurface;
	}

	public Double getGardenSurface() {
		return gardenSurface;
	}

	public void setGardenSurface(Double gardenSurface) {
		this.gardenSurface = gardenSurface;
	}

	public Double getTotalSurface() {
		return totalSurface;
	}

	public void setTotalSurface(Double totalSurface) {
		this.totalSurface = totalSurface;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public House() {
	}

	public House(String quarter, String streetName, Integer streetNumber, Integer zipCode, String town, String country,
			Double houseSurface, Double gardenSurface, Double totalSurface, Calendar registrationDate) {
		super();
		this.quarter = quarter;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
		this.houseSurface = houseSurface;
		this.gardenSurface = gardenSurface;
		this.totalSurface = totalSurface;
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("House [quarter=").append(quarter).append(", streetName=").append(streetName)
				.append(", streetNumber=").append(streetNumber).append(", zipCode=").append(zipCode).append(", town=")
				.append(town).append(", country=").append(country).append(", houseSurface=").append(houseSurface)
				.append(", gardenSurface=").append(gardenSurface).append(", totalSurface=").append(totalSurface)
				.append(", registrationDate=").append(registrationDate).append("]");
		return builder.toString();
	}

}
