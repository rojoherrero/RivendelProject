package org.rojoherrero.rivendel.models.DTO;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

public class UpdateHouseDTO {

	private String quarter;
	private String streetName;
	private Integer streetNumber;
	private Integer zipCode;
	private String town;
	private String country;
	private Double houseSurface;
	private Double gardenSurface;
	private Calendar modificationDate;

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

	public Calendar getModificationData() {
		return modificationDate;
	}

	public void setModificationData(Calendar modificationData) {
		this.modificationDate = modificationData;
	}

}
