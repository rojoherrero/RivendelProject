package org.rojoherrero.rivendel.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.rojoherrero.rivendel.domain.UserRoles;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class WorkerDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 7599921162515902632L;

	@NotNull
	private @Getter UserRoles role = UserRoles.WORKER;

}
