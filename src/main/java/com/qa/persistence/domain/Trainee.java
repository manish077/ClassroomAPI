package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 50)
	private String traineeName;

	public Trainee(Long id, String traineeName) {
		this.id = id;
		this.traineeName = traineeName;
	}

	public Long getTraineeID() {
		return id;
	}

	public void setTraineeID(Long id) {
		this.id = id;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

}
