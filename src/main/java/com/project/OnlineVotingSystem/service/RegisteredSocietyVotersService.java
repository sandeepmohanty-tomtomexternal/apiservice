package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;

public interface RegisteredSocietyVotersService {
	RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter);
	RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter);
	RegisteredSocietyVoters deleteRegisteredVoter(int voterid);
	List<RegisteredSocietyVoters> viewRegisteredVoterList();
	Optional<RegisteredSocietyVoters> searchByVoterID(int voterId);
	RegisteredSocietyVoters loginValidate(String voterIdCardNo, String Password);

}
