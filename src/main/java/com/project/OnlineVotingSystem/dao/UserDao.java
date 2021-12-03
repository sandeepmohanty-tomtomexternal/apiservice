package com.project.OnlineVotingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineVotingSystem.model.User;


public interface UserDao extends JpaRepository<User, Integer>{

}
