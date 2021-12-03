package com.project.OnlineVotingSystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.ElectionResult;
import com.project.OnlineVotingSystem.model.NominatedCandidates;

public interface ElectionResultService {
	ElectionResult addElectionResult(ElectionResult result);
    List<ElectionResult> viewElectionResultList();
    Optional<ElectionResult> viewCandidatewiseResult(int candidateId);
    double viewVotingPercentage();
    double viewCandidateVotingPercent(int candidateId);
    String displayVotingStatistics();
    NominatedCandidates viewHighestVotingPercentCandidate();
    NominatedCandidates viewLowestVotingPercentCandidate();
    int viewInvalidVotes();
    List<NominatedCandidates> candidatewiseInvalidVotesList();
    ElectionResult displayPollingResult(Date pollingDate);


}
