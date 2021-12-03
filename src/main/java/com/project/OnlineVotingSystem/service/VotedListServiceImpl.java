package com.project.OnlineVotingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.CooperativeSocietyDao;
import com.project.OnlineVotingSystem.dao.NominatedCandidateDao;
import com.project.OnlineVotingSystem.dao.RegisteredSocietyVotersDao;
import com.project.OnlineVotingSystem.dao.VotedListDao;
import com.project.OnlineVotingSystem.model.CooperativeSociety;
import com.project.OnlineVotingSystem.model.NominatedCandidates;
import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;
import com.project.OnlineVotingSystem.model.VotedList;

@Service
public class VotedListServiceImpl implements VotedListService {
	
	@Autowired
	VotedListDao votedListDao;
	@Autowired
	RegisteredSocietyVotersDao registeredSocietyVotersDao;
	@Autowired
	NominatedCandidateDao nominatedCandidatesDao;
	@Autowired
	CooperativeSocietyDao cooperativeSocietyDao;
	@Override
	public VotedList castVotedList(VotedList votedList) {
		List<RegisteredSocietyVoters> voters = votedList.getVoter();
		List<RegisteredSocietyVoters> oldList = new ArrayList<>();
		List<RegisteredSocietyVoters> newList = new ArrayList<>();
		CooperativeSociety cooperativeSociety = votedList.getSociety();
		int csId = cooperativeSociety.getSocietyId();
		if(csId!=0) {
			Optional<CooperativeSociety> societyContainer = 
					cooperativeSocietyDao.findById(csId);
			if(societyContainer.isPresent()) {
				votedList.setSociety(societyContainer.get());
			}
		}
		NominatedCandidates candidate = votedList.getCandidate();
		int candidateId = candidate.getCandidateId();
		if(candidateId!=0) {
			Optional<NominatedCandidates> candidateContainer = 
					nominatedCandidatesDao.findById(candidateId);
			if(candidateContainer.isPresent()) {
				votedList.setCandidate(candidateContainer.get());
			}
		}
		if(voters.size()>0) {
			voters.forEach((v)->{
				Optional<RegisteredSocietyVoters> votersContainer 
						= registeredSocietyVotersDao.findById(v.getId());
				if(votersContainer.isPresent()) {
					oldList.add(votersContainer.get());
				}else {
					newList.add(v);
				}
			});
			if(oldList.size()>0) {
				votedList.setVoter(oldList);
				return votedListDao.save(votedList);
			}if(newList.size()>0) {
				votedList.setVoter(newList);
				return votedListDao.save(votedList);
			}
		}
		return votedListDao.save(votedList);
	}

	@Override
	public VotedList updateVotedListDetails(VotedList votedList) {
		int id = votedList.getId();
		Optional<VotedList> existingVotedListContainer = votedListDao.findById(id);
		VotedList existingVotedList = null;
		if(existingVotedListContainer.isPresent()) {
			existingVotedList = existingVotedListContainer.get();
			existingVotedList.setPollingDateTime(votedList.getPollingDateTime());
			existingVotedList.setSociety(votedList.getSociety());
			existingVotedList.setVoter(votedList.getVoter());
			existingVotedList.setCandidate(votedList.getCandidate());
			votedListDao.saveAndFlush(existingVotedList);
		}
		return existingVotedList;
	}

	@Override
	public VotedList deletedVotedListDetails(int id) {
		Optional<VotedList> existingvotedlistContainer = votedListDao.findById(id);
		VotedList existingvotedlist = null;
		if(existingvotedlistContainer.isPresent()) {
			existingvotedlist  = existingvotedlistContainer.get();
			votedListDao.deleteById(id);
		}
		return existingvotedlist;
	}

	@Override
	public List<VotedList> viewVotedList() {
		// TODO Auto-generated method stub
		return votedListDao.findAll();
	}

	@Override
	public Optional<VotedList> searchByVoterId(int voterId) {
		// TODO Auto-generated method stub
		return votedListDao.findById(voterId);
	}

	@Override
	public Optional<NominatedCandidates> searchByNominatedCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return nominatedCandidatesDao.findById(candidateId);
	}

}
