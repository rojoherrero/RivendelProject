package org.rojoherrero.rivendel.domain.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
public class EstateDetailDTO implements Serializable {

	private static final long serialVersionUID = 1693587690646186309L;
	
	private double totalSurface;
	
	private double houseSurface;
	
	private double stableSurface;

}
