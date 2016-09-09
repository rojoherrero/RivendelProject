package org.rojoherrero.rivendel.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.rojoherrero.rivendel.utils.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

	@NotEmpty
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String passwordRepeated;

	@NotNull
	private Role role = Role.USER;
}
