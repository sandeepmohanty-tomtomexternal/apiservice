package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.CooperativeSocietyDao;
import com.project.OnlineVotingSystem.model.CooperativeSociety;

@Service
public class CooperativeSocietyServiceImpl implements CooperativeSocietyService{

	@Autowired
	CooperativeSocietyDao cooperativeSocietyDao;
	@Override
	public CooperativeSociety addSocietyDetails(CooperativeSociety society) {
		// TODO Auto-generated method stub
		return cooperativeSocietyDao.save(society);
	}

	@Override
	public CooperativeSociety updateSocietyDetails(CooperativeSociety society) {
		// TODO Auto-generated method stub
		int cooperativeSocietyId= society.getSocietyId();
		Optional<CooperativeSociety> existingCooperativeSocietyContainer = cooperativeSocietyDao.findById(cooperativeSocietyId);
		CooperativeSociety existingCooperativeSociety= null;
		if( existingCooperativeSocietyContainer.isPresent())
		{
			existingCooperativeSociety =existingCooperativeSocietyContainer.get();
			existingCooperativeSociety.setSocietyName(society.getSocietyName());
			existingCooperativeSociety.setHeadOfSociety(society.getHeadOfSociety());
			existingCooperativeSociety.setVillage(society.getVillage());
			existingCooperativeSociety.setMandal(society.getMandal());
			existingCooperativeSociety.setDistrict(society.getDistrict());
			existingCooperativeSociety.setPincode(society.getPincode());
			cooperativeSocietyDao.saveAndFlush(existingCooperativeSociety);
		}
		return existingCooperativeSociety;
	}

	@Override
	public CooperativeSociety deleteSociety(int societyId) {
		// TODO Auto-generated method stub
		Optional<CooperativeSociety> existingCooperativeSocietyContainer = cooperativeSocietyDao.findById(societyId);
		CooperativeSociety existingCooperativeSociety= null;
		if(existingCooperativeSocietyContainer.isPresent())
		{
			existingCooperativeSociety =existingCooperativeSocietyContainer.get();
			cooperativeSocietyDao.deleteById(societyId);
		}
		return existingCooperativeSociety;
	}

	@Override
	public List<CooperativeSociety> viewSocietiesList() {
		// TODO Auto-generated method stub
		return cooperativeSocietyDao.findAll();
	}

	@Override
	public Optional<CooperativeSociety> viewSocietyById(int societyid) {
		// TODO Auto-generated method stub
		return cooperativeSocietyDao.findById(societyid);
	}
	
}
