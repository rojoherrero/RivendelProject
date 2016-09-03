package org.rojoherrero.rivendel.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "house")
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "street_number")
	private String streetNumber;

	@Column(name = "town")
	private String town;

	@Column(name = "country")
	private String country;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "house_detail_id")
	private HouseDetail houseDetail;

	public HouseDetail getHousetail() {
		return houseDetail;
	}

	public void setHousetail(HouseDetail houseDetail) {
		this.houseDetail = houseDetail;
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

	public long getId() {
		return id;
	}

	public House() {
	}

}
