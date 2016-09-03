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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "house")
public class House {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Getter
	@Setter
	@Column(name = "street_name")
	private String streetName;

	@Getter
	@Setter
	@Column(name = "street_number")
	private String streetNumber;

	@Getter
	@Setter
	@Column(name = "town")
	private String town;

	@Getter
	@Setter
	@Column(name = "country")
	private String country;

	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "house_detail_id")
	private HouseDetail houseDetail;

}
