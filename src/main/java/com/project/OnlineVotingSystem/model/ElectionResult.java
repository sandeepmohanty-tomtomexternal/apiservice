package com.project.OnlineVotingSystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Election_Result")
public class ElectionResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(value = TemporalType.DATE)
	private Date pollingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "e_id")
	private NominatedCandidates candidate;
	private String coop_SocietyName;
	private int totalSocietyVotes;
	private float totalPolledVotes;
	private int totalCandidateVotes;
	private float candidateVotesPercentage;
	private String result;
	
	
	
	public ElectionResult() {
		super();
	}


	public ElectionResult(int id, Date pollingDate, NominatedCandidates candidate, String coop_SocietyName,
			int totalSocietyVotes, float totalPolledVotes, int totalCandidateVotes, float candidateVotesPercentage,
			String result) {
		super();
		this.id = id;
		this.pollingDate = pollingDate;
		this.candidate = candidate;
		this.coop_SocietyName = coop_SocietyName;
		this.totalSocietyVotes = totalSocietyVotes;
		this.totalPolledVotes = totalPolledVotes;
		this.totalCandidateVotes = totalCandidateVotes;
		this.candidateVotesPercentage = candidateVotesPercentage;
		this.result = result;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPollingDate() {
		return pollingDate;
	}
	public void setPollingDate(Date pollingDate) {
		this.pollingDate = pollingDate;
	}
	public NominatedCandidates getCandidate() {
		return candidate;
	}
	public void setCandidate(NominatedCandidates candidate) {
		this.candidate = candidate;
	}
	public String getCoop_SocietyName() {
		return coop_SocietyName;
	}
	public void setCoop_SocietyName(String coop_SocietyName) {
		this.coop_SocietyName = coop_SocietyName;
	}
	public int getTotalSocietyVotes() {
		return totalSocietyVotes;
	}
	public void setTotalSocietyVotes(int totalSocietyVotes) {
		this.totalSocietyVotes = totalSocietyVotes;
	}
	public float getTotalPolledVotes() {
		return totalPolledVotes;
	}
	public void setTotalPolledVotes(float totalPolledVotes) {
		this.totalPolledVotes = totalPolledVotes;
	}
	public int getTotalCandidateVotes() {
		return totalCandidateVotes;
	}
	public void setTotalCandidateVotes(int totalCandidateVotes) {
		this.totalCandidateVotes = totalCandidateVotes;
	}
	public float getCandidateVotesPercentage() {
		return candidateVotesPercentage;
	}
	public void setCandidateVotesPercentage(float candidateVotesPercentage) {
		this.candidateVotesPercentage = candidateVotesPercentage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
