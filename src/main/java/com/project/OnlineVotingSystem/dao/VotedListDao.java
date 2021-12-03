package com.project.OnlineVotingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineVotingSystem.model.VotedList;

public interface VotedListDao extends JpaRepository<VotedList, Integer>{

}
