package com.project.OnlineVotingSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Registered_Society_Voters")
public class RegisteredSocietyVoters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String voterIdCardNo;
    private String firstName;
    private String lastName;
    private String gender;
    private String password;
    private String reservationCategory;
    private String mobileno;
    private String emailId;
    
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "r_id")
    private CooperativeSociety society;
    private boolean castedVote;
    
    
    
	public RegisteredSocietyVoters(int id, String voterIdCardNo, String firstName, String lastName, String gender,
			String password, String reservationCategory, String mobileno, String emailId,  CooperativeSociety society,
			boolean castedVote) {
		super();
		this.id = id;
		this.voterIdCardNo = voterIdCardNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.reservationCategory = reservationCategory;
		this.mobileno = mobileno;
		this.emailId = emailId;
		
		this.society = society;
		this.castedVote = castedVote;
	}
	
	
	public RegisteredSocietyVoters() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoterIdCardNo() {
		return voterIdCardNo;
	}
	public void setVoterIdCardNo(String voterIdCardNo) {
		this.voterIdCardNo = voterIdCardNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReservationCategory() {
		return reservationCategory;
	}
	public void setReservationCategory(String reservationCategory) {
		this.reservationCategory = reservationCategory;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public CooperativeSociety getSociety() {
		return society;
	}
	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}
	public boolean isCastedVote() {
		return castedVote;
	}
	public void setCastedVote(boolean castedVote) {
		this.castedVote = castedVote;
	}

    
}
