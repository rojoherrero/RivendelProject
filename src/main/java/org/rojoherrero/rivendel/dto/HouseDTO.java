package org.rojoherrero.rivendel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseDTO {

	private String streetName;

	private String streetNumber;

	private String town;

	private String country;

	private double surfaceTotal;

	private double surfaceGarden;

	private double surfaceBuild;

	private double surfaceGarage;

	private int rooms;

	private int bedRooms;

	private int restRooms;

}
