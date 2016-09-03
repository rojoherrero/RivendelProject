package org.rojoherrero.rivendel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "house_detail")
public class HouseDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "house_detail_id")
	private long id;

	@OneToOne(mappedBy = "houseDetail")
	private House house;

	@Column(name = "surface_total")
	private double surfaceTotal;

	@Column(name = "surface_garden")
	private double surfaceGarden;

	@Column(name = "sruface_build")
	private double surfaceBuild;

	@Column(name = "surface_garage")
	private double surfaceGarage;

	@Column(name = "total_rooms_number")
	private int rooms;

	@Column(name = "bedrooms_number")
	private int bedRooms;

	@Column(name = "restrooms_number")
	private int restRooms;

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public double getSurfaceTotal() {
		return surfaceTotal;
	}

	public void setSurfaceTotal(double surfaceTotal) {
		this.surfaceTotal = surfaceTotal;
	}

	public double getSurfaceGarden() {
		return surfaceGarden;
	}

	public void setSurfaceGarden(double surfaceGarden) {
		this.surfaceGarden = surfaceGarden;
	}

	public double getSurfaceBuild() {
		return surfaceBuild;
	}

	public void setSurfaceBuild(double surfaceBuild) {
		this.surfaceBuild = surfaceBuild;
	}

	public double getSurfaceGarage() {
		return surfaceGarage;
	}

	public void setSurfaceGarage(double surfaceGarage) {
		this.surfaceGarage = surfaceGarage;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getBedRooms() {
		return bedRooms;
	}

	public void setBedRooms(int bedRooms) {
		this.bedRooms = bedRooms;
	}

	public int getRestRooms() {
		return restRooms;
	}

	public void setRestRooms(int restRooms) {
		this.restRooms = restRooms;
	}

	public long getId() {
		return id;
	}

	public HouseDetail() {
	}
}
