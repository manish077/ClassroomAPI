package com.qa.business.service;


public interface ClassroomService {
	String getAllClassrooms();

	String addClassroom(String classroom);

	String updateClassroom(Long id, String classroom);

	String deleteClassroom(Long id);

}
