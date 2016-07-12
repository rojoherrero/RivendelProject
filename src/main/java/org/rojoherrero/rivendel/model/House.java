package org.rojoherrero.rivendel.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "houses")
public class House {

	private Long id;
	private String quarter;
	private String streetName;
	private Integer streetNumber;
	private String floorAndLetter;
	private String town;
	private String country;
	private Double houseSurface;
	private Double gardenSurface;
	private Double totalSurface;

}
