package com.assignment.service;

import java.util.List;

import com.assignment.model.Candidate;

public interface CandidateService {

	// 1. Creating candidate
	public Candidate createCandidate(Candidate candidate) throws Exception;

	// 3. Getting vote count of a candidate by name
	public int voteCount(String name) throws Exception;

	// 4. Getting all names and votecount
	public List<Candidate> getAllCandidate();

	// 5. Getting winner
	public String getWinner();

	// 2. Caste vote
	public int casteVote(String name) throws Exception;

}
