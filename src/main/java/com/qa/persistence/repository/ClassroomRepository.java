package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllClassrooms();

	String createClassroom(String account);

	String updateClassroom(Long id, String accountToUpdate);

	String deleteClassroom(Long id);
}
