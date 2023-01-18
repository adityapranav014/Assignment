package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Candidate;
import com.assignment.service.CandidateService;

@RestController
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	// 1.creating candidate
	@PostMapping("/entercandidate/{name}")
	public Candidate createCandidate(@PathVariable String name) throws Exception {
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setVoteCount(0);
		return this.candidateService.createCandidate(candidate);
	}
	
	// 2. Caste vote
	@PutMapping("/castvote/{name}") 
	public int casteVote(@PathVariable String name) throws Exception{
		return this.candidateService.casteVote(name);
		
	}
	
	// 3.getting vote count of a candidate by name
	@GetMapping("/countvote/{name}")
	public int voteCount(@PathVariable String name) throws Exception {
		return this.candidateService.voteCount(name);
	}
	
	// 4.Getting all names and votecount
	@GetMapping("/listvote")
	public List<Candidate> getAllCandidate() {
		return this.candidateService.getAllCandidate();
	}
	
	// 5.Getting winner
	@GetMapping("/getwinner")
	public String getWinner() {
		return this.candidateService.getWinner();
	}
}





