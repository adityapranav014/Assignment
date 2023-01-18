package com.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	public Candidate findByName(String name);

}
