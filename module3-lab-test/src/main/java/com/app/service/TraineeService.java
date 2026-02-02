package com.app.service;

import com.app.dto.TraineeDto;

public interface TraineeService {

	public TraineeDto addTrainee(TraineeDto trainee);

	public TraineeDto findById(int traineeId);
}
