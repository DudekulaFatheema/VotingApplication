package com.voter.model;

import java.util.List;

import com.voter.entity.Voter;



public class RequiredResponse {


    private Voter voter;
    private List<Candidate> candidate;
    
	public RequiredResponse() {
		super();
	}
	public RequiredResponse(Voter voter, List<Candidate> candidate) {
		super();
		this.voter = voter;
		this.candidate = candidate;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	public List<Candidate> getCandidate() {
		return candidate;
	}
	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}
    
    
}