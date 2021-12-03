package com.project.OnlineVotingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineVotingSystem.model.NominatedCandidates;

public interface NominatedCandidateDao extends JpaRepository<NominatedCandidates, Integer>{

}
