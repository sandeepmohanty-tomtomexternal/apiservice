package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.NominatedCandidates;

public interface NominatedCandidateService {
	NominatedCandidates addNominatedCandidate(NominatedCandidates candidate);
	NominatedCandidates updateNominatedCandidateDetails(NominatedCandidates candidate);
	NominatedCandidates deleteNominatedCandidate(int candidateId);
	List<NominatedCandidates> viewNominatedCandidatesList();
	Optional<NominatedCandidates> searchByCandidateId(int id);
}
