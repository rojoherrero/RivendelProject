package org.rojoherrero.rivendel.domain.worker;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

public class NewWorkerForm implements Serializable {

	private static final long serialVersionUID = -7142303562422064912L;
	
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
