package org.rojoherrero.rivendel.model.entities;

public class Customer {

	private long id;
	private ContactInfo contactInfo;
	private PersonalInfo personalInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", contactInfo=");
		builder.append(contactInfo);
		builder.append(", personalInfo=");
		builder.append(personalInfo);
		builder.append("]");
		return builder.toString();
	}

	
}
