package org.rojoherrero.rivendel.domain.house;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

public class NewHouseForm implements Serializable{
	
	private static final long serialVersionUID = -3320909773991937322L;
	
	@Getter
	@Setter
	@Column(name = "street_name", nullable = false)
	private String streetName;

	@Getter
	@Setter
	@Column(name = "street_name", nullable = false)
	private int streetNumber;

	@Getter
	@Setter
	@Column(name = "town", nullable = false)
	private String town;

	@Getter
	@Setter
	@Column(name = "zip_code", nullable = false)
	private int zipCode;

	@Getter
	@Setter
	@Column(name = "country_name", nullable = false)
	private String countryName;

}
