package com.qa.persistence.repository;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;
import com.qa.persistence.repository.ClassroomRepository;


@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository{
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject private JSONUtil util;
	
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select c From Classroom c");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}
	
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = JSONUtil.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"Classroom successfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"message\": \"CLASSROOOM sucessfully deleted\"}";
		
	}
	
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroomToUpdate) {
		Classroom updatedClassroom = JSONUtil.getObjectForJSON(classroomToUpdate, Classroom.class);
		Classroom classroomFromDB = findClassroom(id);
		if (classroomToUpdate != null){
			classroomFromDB = updatedClassroom;
			manager.merge(classroomFromDB);
		
		}
		return "{\"message\": \"CLASSROOM sucessfully updated\"}";
	}
	
	private Classroom findClassroom(Long id) {
		return manager.find(Classroom.class, id);
	}



}
