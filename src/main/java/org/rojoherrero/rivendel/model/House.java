package org.rojoherrero.rivendel.model.entities;

public class House {

	private long id;
	private String quarter;
	private String streetName;
	private int streetNumber;
	private String floorAndLetter;
	private String town;
	private String country;
	private long surface;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getFloorAndLetter() {
		return floorAndLetter;
	}

	public void setFloorAndLetter(String floorAndLetter) {
		this.floorAndLetter = floorAndLetter;
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

	public long getSurface() {
		return surface;
	}

	public void setSurface(long surface) {
		this.surface = surface;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("House [id=");
		builder.append(id);
		builder.append(", quarter=");
		builder.append(quarter);
		builder.append(", streetName=");
		builder.append(streetName);
		builder.append(", streetNumber=");
		builder.append(streetNumber);
		builder.append(", floorAndLetter=");
		builder.append(floorAndLetter);
		builder.append(", town=");
		builder.append(town);
		builder.append(", country=");
		builder.append(country);
		builder.append(", surface=");
		builder.append(surface);
		builder.append("]");
		return builder.toString();
	}

}
