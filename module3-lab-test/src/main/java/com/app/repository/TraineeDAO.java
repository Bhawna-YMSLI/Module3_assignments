package com.app.repository;

import com.app.entities.Trainee;

public interface TraineeDAO {
	Trainee save(Trainee trainee);

	Trainee findById(int traineeId);
}
