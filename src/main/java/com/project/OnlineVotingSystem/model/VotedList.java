package com.project.OnlineVotingSystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Voted_List")
public class VotedList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Temporal(value = TemporalType.DATE)
	private Date pollingDateTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vc_id")
	private CooperativeSociety society;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "vr_id")
	private List<RegisteredSocietyVoters> voter;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vn_id")
	private NominatedCandidates candidate;
	
	
	public VotedList() {
		super();
	}


	public VotedList(int id, Date pollingDateTime, CooperativeSociety society, List<RegisteredSocietyVoters> voter,
			NominatedCandidates  candidate) {
		super();
		Id = id;
		this.pollingDateTime = pollingDateTime;
		this.society = society;
		this.voter = voter;
		this.candidate = candidate;
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getPollingDateTime() {
		return pollingDateTime;
	}
	public void setPollingDateTime(Date pollingDateTime) {
		this.pollingDateTime = pollingDateTime;
	}
	public CooperativeSociety getSociety() {
		return society;
	}
	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}
	public List<RegisteredSocietyVoters> getVoter() {
		return voter;
	}
	public void setVoter(List<RegisteredSocietyVoters> voter) {
		this.voter = voter;
	}


	public NominatedCandidates getCandidate() {
		return candidate;
	}


	public void setCandidate(NominatedCandidates candidate) {
		this.candidate = candidate;
	}
	

}
