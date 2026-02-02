package com.app.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.app.entities.Trainee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Profile("jpa")
public class TraineeJpaDAO implements TraineeDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Trainee save(Trainee trainee) {
		em.persist(trainee);
		return trainee;

	}

	@Override
	public Trainee findById(int traineeId) {
		return em.find(Trainee.class, traineeId);

	}

}
