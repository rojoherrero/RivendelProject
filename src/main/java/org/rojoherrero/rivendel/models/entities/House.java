package org.rojoherrero.rivendel.models.entities;

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

	@NotNull
	private Calendar modificationDate;

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

	public Calendar getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Calendar modificationDate) {
		this.modificationDate = modificationDate;
	}

	public House() {
	}

	/**
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
	 * @param registrationDate
	 * @param modificationDate
	 * @author rojoherrero
	 */
	public House(String quarter, String streetName, Integer streetNumber, Integer zipCode, String town, String country,
			Double houseSurface, Double gardenSurface, Double totalSurface, Calendar registrationDate,
			Calendar modificationDate) {
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
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("House [quarter=").append(quarter).append(", streetName=").append(streetName)
				.append(", streetNumber=").append(streetNumber).append(", zipCode=").append(zipCode).append(", town=")
				.append(town).append(", country=").append(country).append(", houseSurface=").append(houseSurface)
				.append(", gardenSurface=").append(gardenSurface).append(", totalSurface=").append(totalSurface)
				.append(", registrationDate=").append(registrationDate).append(", modificationDate=")
				.append(modificationDate).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
