package org.rojoherrero.rivendel.models;

import javax.validation.constraints.NotNull;

/**
 * House form entity for house registration
 * 
 * @author rojoherrero
 *
 */
public class NewHouseForm {

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
	@NotNull
	private Double gardenSurface;

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

}
