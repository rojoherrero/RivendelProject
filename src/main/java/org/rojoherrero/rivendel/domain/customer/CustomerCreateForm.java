package org.rojoherrero.rivendel.domain.customer;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class CustomerCreateForm {
	
	@NotEmpty
	@Setter
	private String email;
	
	@NotEmpty
	@Setter
	private String password;
	
	@NotEmpty
	@Setter
	private String passwordRepeated;
	
	@NotNull
	private CustomerRoles role = CustomerRoles.USER;
	
}
