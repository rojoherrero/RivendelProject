package org.rojoherrero.rivendel.domain.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
public class EstateDTO implements Serializable{
	
	private static final long serialVersionUID = -3320909773991937322L;
	
	private String streetName;

	private int streetNumber;

	private String town;

	private int zipCode;

	private String countryName;

}
