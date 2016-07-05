package org.rojoherrero.rivendel.model.entities;

import java.util.Date;

public class PersonalInfo {

	private String firstName, lastName, gender;
	private Date dob;
	private boolean married;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonalInfo [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", married=");
		builder.append(married);
		builder.append("]");
		return builder.toString();
	}

}
