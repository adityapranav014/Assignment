package com.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	private String name;
	private int voteCount;

	public Candidate() {
	}

	public Candidate(Long id, String name, int voteCount) {
		super();
		this.id = id;
		this.name = name;
		this.voteCount = voteCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", voteCount=" + voteCount + "]";
	}

}
