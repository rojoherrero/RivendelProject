package org.rojoherrero.rivendel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.rojoherrero.rivendel.utils.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Getter
	@Setter
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Getter
	@Setter
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Getter
	@Setter
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

}
