package org.rojoherrero.rivendel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estate_detail")
@NoArgsConstructor(access = AccessLevel.PUBLIC) @ToString
public class EstateDetail implements Serializable {

	private static final long serialVersionUID = -2142849259010651252L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estate_detail_id", nullable = false, updatable = false)
	private @Getter long id;

	@Column(name = "total_surface", nullable = false)
	private @Getter @Setter double totalSurface;

	@Column(name = "house_surface", nullable = false)
	private @Getter @Setter double houseSurface;

	@Column(name = "stable_surface", nullable = true)
	private @Getter @Setter double stableSurface;

	@Column(name = "customer_price", nullable = false)
	private @Getter @Setter double customerPrice;

	@Column(name = "for_sale")
	private @Getter @Setter boolean forSale;

	@OneToOne(mappedBy = "estateDetail")
	private @Getter @Setter Estate estate;

}
