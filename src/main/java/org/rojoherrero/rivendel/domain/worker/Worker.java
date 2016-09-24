package org.rojoherrero.rivendel.domain.worker;

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
@Table(name = "workers")
@NoArgsConstructor
public class Worker {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worker_id", updatable = false, nullable = false)
	private long workerId;

	@Getter
	@Setter
	@Column(name = "worker_name", unique = true, nullable = false)
	private String workerName;

	@Getter
	@Setter
	@Column(name ="password_hash", nullable = false)
	private String passwordHash;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private WorkerRoles role;
}
