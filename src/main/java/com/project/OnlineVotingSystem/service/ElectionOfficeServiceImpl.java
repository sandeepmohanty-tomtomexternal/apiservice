package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.ElectionOfficeDao;
import com.project.OnlineVotingSystem.model.ElectionOfficer;

@Service
public class ElectionOfficeServiceImpl implements ElectionOfficeService {

	@Autowired
	ElectionOfficeDao electionOfficeDao;

	@Override
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer) {
		return electionOfficeDao.save(officer);
	}

	@Override
	public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer) {
		int officerId = officer.getOfficerId();
		Optional<ElectionOfficer> existingElectionOfficerContainer = electionOfficeDao.findById(officerId);
		ElectionOfficer existingElectionOfficer = null;
		if(existingElectionOfficerContainer.isPresent()) {
			existingElectionOfficer = existingElectionOfficerContainer.get();
			existingElectionOfficer.setFirstName(officer.getFirstName());
			existingElectionOfficer.setLastName(officer.getLastName());
			existingElectionOfficer.setPassword(officer.getPassword());
			existingElectionOfficer.setGender(officer.getPassword());
			existingElectionOfficer.setMobileno(officer.getMobileno());
			existingElectionOfficer.setEmailId(officer.getEmailId());
			existingElectionOfficer.setAddress1(officer.getAddress1());
			existingElectionOfficer.setAddress2(officer.getAddress2());
			existingElectionOfficer.setDistrict(officer.getDistrict());
			electionOfficeDao.saveAndFlush(existingElectionOfficer);
		}
		return existingElectionOfficer;
	}

	@Override
	public ElectionOfficer deleteElectionOffice(int officerId) {
		Optional<ElectionOfficer> existingElectionOfficerContainer = electionOfficeDao.findById(officerId);
		ElectionOfficer existingElectionOfficer = null;
		if(existingElectionOfficerContainer.isPresent()) {
			existingElectionOfficer = existingElectionOfficerContainer.get();
			electionOfficeDao.deleteById(officerId);
		}
		
		return existingElectionOfficer;
	}

	@Override
	public Optional<ElectionOfficer> viewElectionOfficeById(int officerId) {
		return electionOfficeDao.findById(officerId);
	}

	@Override
	public List<ElectionOfficer> viewElectionOfficeList() {
		return electionOfficeDao.findAll();
	}

}