package com.project.OnlineVotingSystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.ElectionResultDao;
import com.project.OnlineVotingSystem.dao.NominatedCandidateDao;
import com.project.OnlineVotingSystem.model.ElectionResult;
import com.project.OnlineVotingSystem.model.NominatedCandidates;

@Service
public class ElectionResultServiceImpl implements ElectionResultService{

	@Autowired
	ElectionResultDao electionResultDao;
	@Autowired
	NominatedCandidateDao nominatedCandidateDao;
	@Override
	public ElectionResult addElectionResult(ElectionResult result) {
		NominatedCandidates candidates = result.getCandidate();
		int candidateId = candidates.getCandidateId();
		if(candidateId!=0) {
			
			Optional<NominatedCandidates> candidateContainer = nominatedCandidateDao.findById(candidateId);
			if(candidateContainer.isPresent()) {
				result.setCandidate(candidateContainer.get());
			}
		}
		return electionResultDao.save(result);
	}

	@Override
	public List<ElectionResult> viewElectionResultList() {
		// TODO Auto-generated method stub
		return electionResultDao.findAll();
	}

	@Override
	public Optional<ElectionResult> viewCandidatewiseResult(int candidateId) {
		// TODO Auto-generated method stub
		return electionResultDao.findById(candidateId);
	}

	@Override
	public double viewVotingPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewCandidateVotingPercent(int candidateId) {
		 ElectionResult result = electionResultDao.findVotingPercentage(candidateId);
		return result.getCandidateVotesPercentage();
	}

	@Override
	public String displayVotingStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int viewInvalidVotes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NominatedCandidates> candidatewiseInvalidVotesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectionResult displayPollingResult(Date pollingDate) {
		// TODO Auto-generated method stub
		//return null;
		return electionResultDao.findByDate(pollingDate);  //native query
	}

}
