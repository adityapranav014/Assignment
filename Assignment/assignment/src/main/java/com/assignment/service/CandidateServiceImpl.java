package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assignment.model.Candidate;
import com.assignment.repo.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	// 1. Creating candidate
	@Override
	public Candidate createCandidate(Candidate candidate) throws Exception {

		Candidate local = this.candidateRepository.findByName(candidate.getName());
		if (local != null) {
			throw new Exception("Candidate already exist!");
		} else {
			return this.candidateRepository.save(candidate);
		}
	}

	// 2. Caste vote
	@Override
	public int casteVote(String name) throws Exception {

		Candidate local = this.candidateRepository.findByName(name);
		if (local == null) {
			throw new Exception("Candidate does not exist!");
		} else {
			int votecount = local.getVoteCount();
			local.setVoteCount(votecount + 1);
			candidateRepository.save(local);
			return local.getVoteCount();
		}

	}

	// 3. Getting vote count of a candidate by name
	@Override
	public int voteCount(String name) throws Exception {

		Candidate local = this.candidateRepository.findByName(name);
		if (local == null) {
			throw new Exception("Candidate does not exist!");
		} else {

			return local.getVoteCount();
		}

	}

	// 4. Getting all candidates with their votes
	@Override
	public List<Candidate> getAllCandidate() {
		return this.candidateRepository.findAll();
	}

	// 5. Getting winner
	@Override

//	SELECT name FROM candidates 
//	WHERE vote_count IN (SELECT MAX(vote_count) FROM candidates);

	public String getWinner() {
		List<Candidate> winner = candidateRepository.findAll(Sort.by(Sort.Direction.DESC, "voteCount"));
		Candidate won = winner.get(0);
		if (winner.get(0).getVoteCount() == winner.get(1).getVoteCount()) {
			return "Draw, No winner";
		}
		return won.getName();

	}

}
