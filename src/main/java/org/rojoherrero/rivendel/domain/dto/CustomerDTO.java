package org.rojoherrero.rivendel.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.rojoherrero.rivendel.domain.UserRoles;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CustomerDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 2486132412184941371L;

	@NotNull
	private UserRoles role = UserRoles.CUSTOMER;

}
