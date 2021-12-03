package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.NominatedCandidates;
import com.project.OnlineVotingSystem.model.VotedList;

public interface VotedListService {
	VotedList castVotedList(VotedList votedList);
	VotedList updateVotedListDetails(VotedList votedList);
	VotedList deletedVotedListDetails(int id);
	
	List<VotedList> viewVotedList();
	Optional<VotedList> searchByVoterId(int voterId);
	
	Optional<NominatedCandidates> searchByNominatedCandidateId(int candidateId);


}
