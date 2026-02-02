package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TraineeDto;
import com.app.service.TraineeService;

@RestController
public class TraineeController {

	private final TraineeService traineeService;

	TraineeController(TraineeService traineeService) {
		this.traineeService = traineeService;
	}

	@GetMapping(path = "trainees/{id}")
	public ResponseEntity<TraineeDto> getById(@PathVariable(name = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(traineeService.findById(id));
	}

	@PostMapping(path = "trainees")
	public ResponseEntity<TraineeDto> addTrainee(@RequestBody TraineeDto traineeDto) {
		TraineeDto saved = traineeService.addTrainee(traineeDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

}
