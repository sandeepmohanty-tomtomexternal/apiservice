package com.project.OnlineVotingSystem.ctrl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingSystem.model.ElectionOfficer;
import com.project.OnlineVotingSystem.service.ElectionOfficeService;


@RestController
@RequestMapping("/api")
public class ElectionOfficerController {
	
	@Autowired
	ElectionOfficeService electionOfficeService;
	
	
    @PostMapping("/officers")
	public ElectionOfficer createOffice(@RequestBody ElectionOfficer office) 
	{
		return electionOfficeService.addElectionOfficerDetails(office);
	
	}
	
	
	@PutMapping("/officers")
	public ElectionOfficer updateOffice(@RequestBody ElectionOfficer office) 
	{
		return electionOfficeService.updateElectionOfficerDetails(office);
	
	}
	
	
	@DeleteMapping("/officers/{officerId}")
	public ElectionOfficer deleteOffice(@PathVariable int officerId) 
	{
		return electionOfficeService.deleteElectionOffice(officerId);
	
	}
	
	@GetMapping("/officers/{officerId}")
	public Optional<ElectionOfficer> officerById(@PathVariable int officerId) 
	{
		return electionOfficeService.viewElectionOfficeById(officerId);
	
	}
	@GetMapping("/officers")
	public List<ElectionOfficer> viewElectionOfficerList()
	{
		return electionOfficeService.viewElectionOfficeList();
	
	}
	
	
}
