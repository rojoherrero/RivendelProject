package org.rojoherrero.rivendel.domain.house;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "house")
@NoArgsConstructor
public class House implements Serializable {

	private static final long serialVersionUID = 7582402224512635700L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "house_id", nullable = false, updatable = false)
	private long houseId;

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
