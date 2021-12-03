package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.ElectionOfficer;

public interface ElectionOfficeService {
	ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer);
	ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer);
	ElectionOfficer deleteElectionOffice(int officerId);
	Optional<ElectionOfficer> viewElectionOfficeById(int officerId);
	List<ElectionOfficer> viewElectionOfficeList();

}
