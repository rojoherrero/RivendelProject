package org.rojoherrero.rivendel.models.forms;

import javax.validation.constraints.NotNull;

/**
 * House form entity for house search
 * 
 * @author rojoherrero
 *
 */
public class HouseSearchForm {

	@NotNull
	private String town;

	private Double houseSurface;

	private Double gardenSurface;

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
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

}
