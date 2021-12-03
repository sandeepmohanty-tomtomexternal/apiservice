package com.project.OnlineVotingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;

public interface RegisteredSocietyVotersDao extends JpaRepository<RegisteredSocietyVoters, Integer>{
	
	@Query(value = "SELECT * FROM Registered_Society_Voters R WHERE R.voter_id_card_no = ?1 and R.password =?2",nativeQuery =true)
	RegisteredSocietyVoters findUserByUserNamePassword(String voterIdCardNo, String password);
	
}
