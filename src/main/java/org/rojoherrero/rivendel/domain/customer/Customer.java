package org.rojoherrero.rivendel.domain.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = -829211506248538888L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private long userId;

	@Getter
	@Setter
	@Column(name = "user_email", nullable = false, unique = true)
	private String email;
	
	@Getter
	@Setter
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private CustomerRoles role = CustomerRoles.USER;

}
