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

	private Double surfaceTotal;

	private Double surfaceGarden;

	private Double surfaceBuild;

	private Double surfaceGarage;

	private Integer rooms;

	private Integer bedRooms;

	private Integer restRooms;

}
