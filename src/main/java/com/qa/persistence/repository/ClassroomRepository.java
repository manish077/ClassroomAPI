package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllClassrooms();

	String createClassroom(String classroom);

	String updateClassroom(Long id, String classroomToUpdate);

	String deleteClassroom(Long id);
}
