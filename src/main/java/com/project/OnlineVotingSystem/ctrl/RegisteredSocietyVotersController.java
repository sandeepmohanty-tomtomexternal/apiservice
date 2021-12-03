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


import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;
import com.project.OnlineVotingSystem.service.RegisteredSocietyVotersService;

@RestController
@RequestMapping("/api/regsocietyvoter")
public class RegisteredSocietyVotersController {
	@Autowired
	RegisteredSocietyVotersService registeredSocietyVotersService;
	@PostMapping("/voters")
	public RegisteredSocietyVoters voterRegistration(@RequestBody RegisteredSocietyVoters voter)
	{
		return registeredSocietyVotersService.voterRegistration(voter);
		
	}
	
	@PutMapping("/voters")
	public RegisteredSocietyVoters updateRegisteredVoterDetails(@RequestBody RegisteredSocietyVoters voter)
	{
		return registeredSocietyVotersService.updateRegisteredVoterDetails(voter);
		
	}
	
	@DeleteMapping("/voters/{voterId}")
	public RegisteredSocietyVoters deleteRegisteredVoter(@PathVariable int voterId)
	{
		return registeredSocietyVotersService.deleteRegisteredVoter(voterId);
		
	}
	
	@GetMapping("/voters")
	public List<RegisteredSocietyVoters> viewRegisteredVoterList()
	{
		return registeredSocietyVotersService.viewRegisteredVoterList();
	
	}
	
	@GetMapping("/voters/{voterId}")
	public Optional<RegisteredSocietyVoters> searchByVoterID(@PathVariable int voterId) 
	{
		return registeredSocietyVotersService.searchByVoterID(voterId);
	
	}
	
	/*@PostMapping("voters/validateid")
	public RegisteredSocietyVoters loginValidate(@PathVariable String voterIdCardNo, @PathVariable String password) 
	{
		return registeredSocietyVotersService.loginValidate(voterIdCardNo,password);
	
	}*/
	
	
}
