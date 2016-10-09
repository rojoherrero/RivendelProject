package org.rojoherrero.rivendel.domain.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
public class UserDetailDTO {

	private String firstName;

	private String lastName;
}
