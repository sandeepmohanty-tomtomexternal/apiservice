package com.project.OnlineVotingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineVotingSystem.model.ElectionOfficer;

public interface ElectionOfficeDao extends JpaRepository<ElectionOfficer, Integer>{

}
