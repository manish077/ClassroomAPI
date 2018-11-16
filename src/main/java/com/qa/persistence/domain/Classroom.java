package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 50)
	private String trainer;
	@Column(length = 100)
	private int trainerID;
	@OneToMany()
	private List<Trainee> traineeList = new ArrayList<Trainee>();

	public Long getClassroomID() {
		return id;
	}

	public void setClassroomID(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public List<Trainee> getTraineeList() {
		return traineeList;
	}

	public void setTraineeList(List<Trainee> traineeList) {
		this.traineeList = traineeList;
	}

}
