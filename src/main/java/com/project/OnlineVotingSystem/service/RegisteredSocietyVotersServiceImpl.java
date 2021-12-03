package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.CooperativeSocietyDao;
import com.project.OnlineVotingSystem.dao.RegisteredSocietyVotersDao;
import com.project.OnlineVotingSystem.model.CooperativeSociety;
import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;

@Service
public class RegisteredSocietyVotersServiceImpl implements RegisteredSocietyVotersService {

	@Autowired
	RegisteredSocietyVotersDao registeredSocietyVotersDao;
    @Autowired
    CooperativeSocietyDao cooperativeSocietyDao;
	@Override
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {
		int societyId = null!=voter.getSociety()?voter.getSociety().getSocietyId():0;
		if(societyId==0) {
			return registeredSocietyVotersDao.save(voter);
		}
		Optional<CooperativeSociety> society = cooperativeSocietyDao.findById(societyId);
		if(society.isPresent()) {
			voter.setSociety(society.get());
			return registeredSocietyVotersDao.save(voter);
		}
		return new RegisteredSocietyVoters();
	}

	@Override
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
		int registeredSocietyVotersId = voter.getId();
		Optional<RegisteredSocietyVoters> exisitingRegisteredSocietyVotersContainer = registeredSocietyVotersDao
				.findById(registeredSocietyVotersId);
		RegisteredSocietyVoters existingRegisteredSocietyVoters = null;
		if (exisitingRegisteredSocietyVotersContainer.isPresent()) {
			existingRegisteredSocietyVoters = exisitingRegisteredSocietyVotersContainer.get();
            
			existingRegisteredSocietyVoters.setCastedVote(voter.isCastedVote());
			if(null!=voter.getEmailId())
			existingRegisteredSocietyVoters.setEmailId(voter.getEmailId());
			if(null!=voter.getFirstName())
			existingRegisteredSocietyVoters.setFirstName(voter.getFirstName());
			if(null!=voter.getGender())
			existingRegisteredSocietyVoters.setGender(voter.getGender());
			if(null!=voter.getLastName())
			existingRegisteredSocietyVoters.setLastName(voter.getLastName());
			if(null!=voter.getMobileno())
			existingRegisteredSocietyVoters.setMobileno(voter.getMobileno());
			if(null!=voter.getPassword())
			existingRegisteredSocietyVoters.setPassword(voter.getPassword());
			if(null!=voter.getReservationCategory())
			existingRegisteredSocietyVoters.setReservationCategory(voter.getReservationCategory());
			if(null!=voter.getSociety())
			existingRegisteredSocietyVoters.setSociety(voter.getSociety());
			if(null!=voter.getVoterIdCardNo())
			existingRegisteredSocietyVoters.setVoterIdCardNo(voter.getVoterIdCardNo());

			registeredSocietyVotersDao.saveAndFlush(existingRegisteredSocietyVoters);
		}
		return existingRegisteredSocietyVoters;
	}

	@Override
	public RegisteredSocietyVoters deleteRegisteredVoter(int voterId) {

		Optional<RegisteredSocietyVoters> exisitingRegisteredSocietyVotersContainer = registeredSocietyVotersDao
				.findById(voterId);
		;
		RegisteredSocietyVoters existingRegisteredSocietyVoters = null;
		if (exisitingRegisteredSocietyVotersContainer.isPresent()) {
			existingRegisteredSocietyVoters = exisitingRegisteredSocietyVotersContainer.get();
			registeredSocietyVotersDao.deleteById(voterId);
		}
		return existingRegisteredSocietyVoters;
	}

	@Override
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() {

		return registeredSocietyVotersDao.findAll();
	}

	@Override
	public Optional<RegisteredSocietyVoters> searchByVoterID(int voterid) {

		return registeredSocietyVotersDao.findById(voterid);
	}

	@Override
	public RegisteredSocietyVoters loginValidate(String voterIdCardNo, String password) {

		return registeredSocietyVotersDao.findUserByUserNamePassword(voterIdCardNo, password);
	}

}