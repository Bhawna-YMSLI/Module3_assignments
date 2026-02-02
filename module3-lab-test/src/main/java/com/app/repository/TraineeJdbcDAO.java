package com.app.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.app.repository.Mappers.TraineeMapper;

import com.app.entities.Trainee;

@Repository
@Profile("jdbc")
public class TraineeJdbcDAO implements TraineeDAO {

	private JdbcTemplate jdbcTemplate;

	public TraineeJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Trainee save(Trainee trainee) {
		String sql = "INSERT INTO trainee_table(name, age, marks) VALUES (?, ?, ?)";

		jdbcTemplate.update(sql, trainee.getName(), trainee.getAge(), trainee.getMarks());

		return trainee;
	}

	@Override
	public Trainee findById(int traineeId) {
		String sql = "select name, age, marks from trainee_table where id = ?";

		return jdbcTemplate.query(sql, new TraineeMapper(), traineeId).stream().findFirst().orElse(null);
	}
}
