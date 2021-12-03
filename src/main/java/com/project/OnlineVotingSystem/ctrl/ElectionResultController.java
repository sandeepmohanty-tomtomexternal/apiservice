package com.project.OnlineVotingSystem.ctrl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingSystem.model.*;
import com.project.OnlineVotingSystem.service.*;

@RestController
@RequestMapping("/api/electionresult")
public class ElectionResultController {

    @Autowired
    ElectionResultService electionResultService;
    
    @PostMapping("/results")
    public ElectionResult addElectionResult(@RequestBody ElectionResult result)
    {
   	 return electionResultService.addElectionResult(result);
    }
    
    @GetMapping("/results")
    public List<ElectionResult> viewElectionResultList()
    {
   	 return electionResultService.viewElectionResultList();
    }
    
    @GetMapping("/results/{candidateId}")
    public Optional<ElectionResult> viewCandidatewiseResult(@PathVariable int candidateId) 
    {
   	 return electionResultService.viewCandidatewiseResult(candidateId);    
    }
    
    
    @GetMapping("/results/percentage/{candidateId}")
    public double viewCandidateVotingPercent(@PathVariable int candidateId) 
    {
   	 return electionResultService.viewCandidateVotingPercent(candidateId);
    }
 
}
