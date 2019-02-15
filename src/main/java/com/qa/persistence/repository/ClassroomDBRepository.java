package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"Classroom has been added\"}";
	}

	@Override
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();

		return util.getJSONForObject(classrooms);

	}

	@Override
	public String getAClassroom(String option) {
		Query query = manager.createQuery("Select a FROM Classroom a where classroomId = " + option);
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		if (manager.contains(manager.find(Classroom.class, id))) {

			manager.remove(manager.find(Classroom.class, id));
		}
		return "{\"message\": \"Classroom sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String updateClassroom(String classroom, Long id) {
		return null;
	}

}
