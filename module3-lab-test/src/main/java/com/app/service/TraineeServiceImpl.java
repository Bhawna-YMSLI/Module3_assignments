package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.TraineeDto;
import com.app.entities.Trainee;
import com.app.exception.TraineeDataAccessException;
import com.app.repository.TraineeDAO;
import com.app.util.TraineeConvertor;

@Service
public class TraineeServiceImpl implements TraineeService {
	private final TraineeDAO traineeDAO;

	TraineeServiceImpl(TraineeDAO traineeDAO) {
		this.traineeDAO = traineeDAO;
	}

	@Transactional
	@Override
	public TraineeDto addTrainee(TraineeDto traineeDto) {
		return TraineeConvertor.convertToTraineeDto(traineeDAO.save(TraineeConvertor.convertToTrainee(traineeDto)));

	}

	@Transactional
	@Override
	public TraineeDto findById(int id) {
		Trainee trainee = traineeDAO.findById(id);
		if (trainee != null) {
			return TraineeConvertor.convertToTraineeDto(trainee);
		}

		throw new TraineeDataAccessException("trainee not found");

	}

}
