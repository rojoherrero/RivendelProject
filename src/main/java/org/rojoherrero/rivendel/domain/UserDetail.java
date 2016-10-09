package org.rojoherrero.rivendel.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_details")
@NoArgsConstructor(access = AccessLevel.PUBLIC) @ToString
public class UserDetail implements Serializable {

	private static final long serialVersionUID = -7421670472655489043L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "user_detail_id", nullable = false, updatable = false, unique = true)
	private @Getter long id;

	@Column(name = "first_name", nullable = false)
	private @Getter @Setter String firstName;

	@Column(name = "last_name", nullable = false)
	private @Getter @Setter String lastName;

	@Column(name = "dob", nullable = false)
	private @Getter @Setter Calendar dob;

}
