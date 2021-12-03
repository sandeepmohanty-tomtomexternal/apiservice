package com.project.OnlineVotingSystem.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.OnlineVotingSystem.model.ElectionResult;

public interface ElectionResultDao extends JpaRepository<ElectionResult, Integer>{

	@Query(value = "SELECT * FROM Election_Result WHERE polling_date = ?1", nativeQuery =true)
	ElectionResult findByDate(Date polling_date);
	@Query(value = "SELECT * FROM Election_Result WHERE e_id = ?1", nativeQuery =true)
	ElectionResult findVotingPercentage(int candidateId);
}
