package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.business.service.ClassroomService;
import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	private static final Logger LOGGER = Logger.getLogger(ClassroomService.class);

	@Inject
	private ClassroomRepository repo;
	
	public String getAllClassrooms() {
		LOGGER.info("in ClassroomServicesEndPoint, getAllClassrooms");
		;
		return repo.getAllClassrooms();
	}
	
	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}
	
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);

	}
	
	public String addClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}
