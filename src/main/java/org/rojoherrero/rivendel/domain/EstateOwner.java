package org.rojoherrero.rivendel.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estates_owners")
@NoArgsConstructor(access = AccessLevel.PUBLIC) @ToString
public class EstateOwner implements Serializable {

	private static final long serialVersionUID = 6361882615938493803L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "estates_owners_id", nullable = false, updatable = false)
	private @Getter long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true, nullable = false, updatable = true)
	private @Getter @Setter User user;

	@OneToMany(mappedBy = "estateOwner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private @Getter @Setter List<Estate> estate;

}
