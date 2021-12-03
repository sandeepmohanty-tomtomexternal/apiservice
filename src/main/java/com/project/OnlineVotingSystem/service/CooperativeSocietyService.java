package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.CooperativeSociety;

public interface CooperativeSocietyService {
	CooperativeSociety addSocietyDetails(CooperativeSociety society);
	CooperativeSociety updateSocietyDetails(CooperativeSociety society);
	CooperativeSociety deleteSociety(int societyId);
    List<CooperativeSociety> viewSocietiesList();
    Optional<CooperativeSociety> viewSocietyById(int societyid);

}
