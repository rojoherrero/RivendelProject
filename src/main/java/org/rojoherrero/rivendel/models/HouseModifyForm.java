package org.rojoherrero.rivendel.models;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

public class HouseModifyForm {

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
	private Calendar modificationData;
}
