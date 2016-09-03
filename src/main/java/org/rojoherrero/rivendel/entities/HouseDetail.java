package org.rojoherrero.rivendel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "house_detail")
public class HouseDetail {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "house_detail_id")
	private long id;

	@Getter
	@Setter
	@OneToOne(mappedBy = "houseDetail")
	private House house;

	@Getter
	@Setter
	@Column(name = "surface_total")
	private double surfaceTotal;

	@Getter
	@Setter
	@Column(name = "surface_garden")
	private double surfaceGarden;

	@Getter
	@Setter
	@Column(name = "sruface_build")
	private double surfaceBuild;

	@Getter
	@Setter
	@Column(name = "surface_garage")
	private double surfaceGarage;

	@Getter
	@Setter
	@Column(name = "total_rooms_number")
	private int rooms;

	@Getter
	@Setter
	@Column(name = "bedrooms_number")
	private int bedRooms;

	@Getter
	@Setter
	@Column(name = "restrooms_number")
	private int restRooms;
}
