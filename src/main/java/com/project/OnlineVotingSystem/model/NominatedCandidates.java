package com.project.OnlineVotingSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Nominated_Candidates")
public class NominatedCandidates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidateId;
	private String nominatonFormNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cs_id")
	private CooperativeSociety society;
	
	
	
	public NominatedCandidates(int candidateId, String nominatonFormNo, CooperativeSociety society) {
		super();
		this.candidateId = candidateId;
		this.nominatonFormNo = nominatonFormNo;
		this.society = society;
	}

	
	
	public NominatedCandidates() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getNominatonFormNo() {
		return nominatonFormNo;
	}
	public void setNominatonFormNo(String nominatonFormNo) {
		this.nominatonFormNo = nominatonFormNo;
	}

	public CooperativeSociety getSociety() {
		return society;
	}

	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}
	
}
