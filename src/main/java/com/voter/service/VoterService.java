package com.voter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voter.entity.Voter;
import com.voter.exception.NullUserFound;
import com.voter.exception.NullUserNameFoundException;
import com.voter.exception.NullValueFoundException;

@Service
public interface VoterService {
	public Voter createVoter(Voter voter) throws NullValueFoundException;
	
	public void deleteByVoterId(int voterId)throws Exception;
	
	public Voter updateVoter(Voter voter) throws Exception;
	
	public Voter getByVoterId(Integer vid) throws NullUserFound;
	
	public List<Voter> getAllVoters() throws Exception;
	
	public Voter registerVoter(Voter voter) throws NullUserFound, NullUserNameFoundException;
	
	public  Voter loginVoter(String userName, String password) throws NullUserFound;
public List<Voter> findByCandId(String candId);
}
