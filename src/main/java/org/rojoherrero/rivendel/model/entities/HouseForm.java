package org.rojoherrero.rivendel.model.entities;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class HouseForm {

	@NotEmpty
	private String town;

	@NotEmpty
	private String country;

	@Min(20)
	private long surface;

	private String quarter;

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

	public long getSurface() {
		return surface;
	}

	public void setSurface(long surface) {
		this.surface = surface;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HouseForm [town=");
		builder.append(town);
		builder.append(", country=");
		builder.append(country);
		builder.append(", surface=");
		builder.append(surface);
		builder.append(", quarter=");
		builder.append(quarter);
		builder.append("]");
		return builder.toString();
	}
	
	

}
