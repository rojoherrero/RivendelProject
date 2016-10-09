package org.rojoherrero.rivendel.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PUBLIC) @ToString
public class User implements Serializable{

	private static final long serialVersionUID = 8563207443443305455L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private @Getter long userId;

	@Column(name = "user_email", nullable = false, unique = true)
	private @Getter @Setter String email;

	@Column(name = "password_hash", nullable = false)
	private @Getter @Setter String passwordHash;

	@Enumerated(EnumType.STRING)
	private @Getter @Setter UserRoles role;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name ="user_detail_id")
	private @Getter @Setter UserDetail userDetail;

}
