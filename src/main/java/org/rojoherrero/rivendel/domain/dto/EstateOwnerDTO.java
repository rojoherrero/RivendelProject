package org.rojoherrero.rivendel.domain.dto;

import java.io.Serializable;

import org.rojoherrero.rivendel.domain.Estate;
import org.rojoherrero.rivendel.domain.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
public class EstateOwnerDTO implements Serializable{

	private static final long serialVersionUID = 2801323548405033435L;

	private User user;
	
	private Estate estate;
}
