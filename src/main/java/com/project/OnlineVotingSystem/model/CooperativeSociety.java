package com.project.OnlineVotingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Cooperative_Society")
public class CooperativeSociety {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int societyId;
    private String societyName;
    private String headOfSociety;
    private String village;
    private String mandal;
    private String district;
    private String pincode;
    
       
	public CooperativeSociety() {
		super();
	}


	public CooperativeSociety(int societyId, String societyName, String headOfSociety, String village, String mandal,
			String district, String pincode) {
		super();
		this.societyId = societyId;
		this.societyName = societyName;
		this.headOfSociety = headOfSociety;
		this.village = village;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
	}
	
	
	public int getSocietyId() {
		return societyId;
	}
	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	public String getHeadOfSociety() {
		return headOfSociety;
	}
	public void setHeadOfSociety(String headOfSociety) {
		this.headOfSociety = headOfSociety;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

    
}
