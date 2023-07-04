package com.voter.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voter.entity.Voter;
import com.voter.exception.NullUserFound;
import com.voter.exception.NullUserNameFoundException;
import com.voter.exception.NullValueFoundException;
import com.voter.repository.VoterRepository;

@Service
public class VoterServiceImpl  implements VoterService {

	
	@Autowired
	private VoterRepository voterRepository;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Voter createVoter(Voter voter) throws NullValueFoundException {
		Voter savedVoter = voterRepository.save(voter);
		int age=voter.getAge();;
		if(age >= 18)  {
			
			return savedVoter;
		}
		else
		throw new NullValueFoundException("age is less than 18");
		
	}


	@Override

	public Voter updateVoter(Voter voter) throws Exception {

	Voter existingVoter = voterRepository.findById(voter.getVoterId()).orElse(null);

	existingVoter.setAge(voter.getAge());
    existingVoter.setPhoneNumber(voter.getPhoneNumber());

	existingVoter.setGender(voter.getGender());
	
	existingVoter.setUserName(voter.getUserName());
	existingVoter.setPassWord(voter.getPassWord());
	return voterRepository.save(existingVoter);

	}

	@Override
	public List<Voter> getAllVoters() throws Exception {
		List<Voter> allVoters = voterRepository.findAll();
		return allVoters;
	}

	@Override
	public Voter registerVoter(Voter voter) throws NullUserFound, NullUserNameFoundException {
		if(voter.getUserName() == null || voter.getUserName() == "") {
			throw new NullUserNameFoundException("username id cannot be null");
		}
		
	else if (voter.getUserName().isEmpty() ||  voter.getUserName().isEmpty()
				|| voter.getPassWord().isEmpty()) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		else if (voter.getUserName().equals("string") ||  voter.getPassWord().equals("string") || voter.getUserName().equals("string") ) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		return voterRepository.save(voter);
	}
	

	@Override
	public Voter loginVoter(String userName, String password) throws NullUserFound {
		if(userName.equals("")|| userName.equals("string")|| password.equals("")|| password.equals("string")) {
			throw new NullUserFound("Username or Password Cannot be empty");
		}
			
		Voter v =  voterRepository.findVoterByuserNamepassWord(userName, password);
		
		if(v == null) {
			throw new NullUserFound("Cant Login voter username and Password dont match");
		}
		
		return v;
	}



	



	@Override
	public Voter getByVoterId(Integer vid) throws NullUserFound {
		if(vid == 0) {
			throw new NullUserFound("Null value is not excepted");
		}
		
		return voterRepository.getByVoterId(vid) ;
	}



	@Override
	public void deleteByVoterId(int voterId) throws Exception {
		// TODO Auto-generated method stub
		voterRepository.deleteById(voterId);
	}


	@Override
	public List<Voter> findByCandId(String candId) {
		// TODO Auto-generated method stub
		return voterRepository.findByCandId(candId);
	}
	



	}
	



