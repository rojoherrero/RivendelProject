package org.rojoherrero.rivendel.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estate")
@NoArgsConstructor(access = AccessLevel.PUBLIC) @ToString
public class Estate implements Serializable {

	private static final long serialVersionUID = 7582402224512635700L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estate_id", nullable = false, updatable = false)
	private @Getter long id;

	@Column(name = "street_name", nullable = false)
	private @Getter @Setter String streetName;

	@Column(name = "street_number", nullable = false)
	private @Getter @Setter int streetNumber;

	@Column(name = "town", nullable = false)
	private @Getter @Setter String town;

	@Column(name = "zip_code", nullable = false)
	private @Getter @Setter int zipCode;

	@Column(name = "country_name", nullable = false)
	private @Getter @Setter String countryName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estate_detail_id")
	private @Getter @Setter EstateDetail estateDetail;
	
	@ManyToOne
	@JoinColumn(name ="estate_owner_id")
	private @Getter @Setter EstateOwner estateOwner;
}
