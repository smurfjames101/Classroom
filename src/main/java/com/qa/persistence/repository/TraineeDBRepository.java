package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTraineeItem = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTraineeItem);
		return "{\"message\": \"Item has been added\"}";
	}

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Trainee a");
		Collection<Trainee> traineeItems = (Collection<Trainee>) query.getResultList();

		return util.getJSONForObject(traineeItems);
	}

	@Override
	public String updateTrainee(String trainee, Long trainee_id) {
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeId) {
		if (manager.contains(manager.find(Trainee.class, traineeId))) {

			manager.remove(manager.find(Trainee.class, traineeId));
		}
		return "{\"message\": \"Trainee Item Sucessfully Deleted\"}";
	}

	@Override
	public String getATrainee(String option){
		Query query = manager.createQuery("Select a FROM Trainee a where traineeId=" + option );
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
