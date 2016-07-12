package org.rojoherrero.rivendel.model;

public class ContactInfo {

	private int phoneNumber;
	private int mobileNumber;
	private String streetName;
	private String streetNumber;
	private String buildingFloor;
	private String floorDoor;
	private int zipCode;
	private String town;
	private String country;

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getBuildingFloor() {
		return buildingFloor;
	}

	public void setBuildingFloor(String buildingFloor) {
		this.buildingFloor = buildingFloor;
	}

	public String getFloorDoor() {
		return floorDoor;
	}

	public void setFloorDoor(String floorDoor) {
		this.floorDoor = floorDoor;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactInfo [phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", streetName=");
		builder.append(streetName);
		builder.append(", streetNumber=");
		builder.append(streetNumber);
		builder.append(", buildingFloor=");
		builder.append(buildingFloor);
		builder.append(", floorDoor=");
		builder.append(floorDoor);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", town=");
		builder.append(town);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}

}
