package org.rojoherrero.rivendel.domain.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter 
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3464827233449933281L;

	@NotEmpty
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String passwordRepeated;

}
