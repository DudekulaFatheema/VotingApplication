package com.voter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.voter.entity.Voter;
import com.voter.exception.NullUserFound;
import com.voter.exception.NullUserNameFoundException;
import com.voter.exception.NullValueFoundException;
import com.voter.model.Candidate;
import com.voter.model.RequiredResponse;
import com.voter.service.VoterService;


@RestController
@RequestMapping("/voter")
@CrossOrigin("http://localhost:4200/")
public class VoterController {
	
	@Autowired
	VoterService voterService;
	
	@Autowired
	RestTemplate restTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(VoterController.class);
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to Voter controller";
	}
	
	
	@PostMapping("/addvoter")
	public Voter createVoter(@RequestBody Voter voter) throws NullValueFoundException {
	    Logger logger = LoggerFactory.getLogger(getClass());
	    logger.info("Creating voter: {}", voter);

	    Voter createdVoter = voterService.createVoter(voter);

	    logger.info("Voter created successfully: {}", createdVoter);
	    return createdVoter;
	}
	
	
	@PutMapping("/update/{voterId}")

	public Voter updateVoter(@PathVariable int voterId, @RequestBody Voter voterDetails)

	throws NullUserFound, NullValueFoundException {

	voterService.getByVoterId(voterId);

	voterDetails.setVoterId(voterId);

	Voter updateVoter = voterService.createVoter(voterDetails);

	return updateVoter;
	}
	
	
	@DeleteMapping("/delete/{voterId}")
    public String delete(@PathVariable int voterId) throws Exception {
    try {
    voterService.deleteByVoterId(voterId);
    } catch (Exception e) {

    e.printStackTrace();

    }
//    mylogs.info("Deleted = " + voterId + " Data");
//    return "Deleted Id = " + voterId + " Data";
    String deletedMessage = String.format("Deleted = %s Data", voterId);
    return String.format("Deleted Id = %s Data", voterId);

    }
	
	@GetMapping("/voters")
	public List<Voter> getAllVoters() {
		try { 
			List<Voter> allExtractedVoters = voterService.getAllVoters();
			return allExtractedVoters;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/loginVoter/{userName}/{password}")
	public Voter loginVoter(@PathVariable String userName, @PathVariable String password) throws NullUserFound
	{
		return voterService.loginVoter(userName, password);
	}
	
	@GetMapping("/voterId/{voterId}")
	public Voter getByVoterId(@PathVariable int voterId) throws Exception {
		return voterService.getByVoterId(voterId);
	}



@PostMapping("/registerVoter")
public Voter registerVoter(@RequestBody Voter voter) throws NullUserFound, NullUserNameFoundException {
    Logger logger = LoggerFactory.getLogger(getClass());
    logger.info("Registering voter: {}", voter);

    Voter registeredVoter = voterService.registerVoter(voter);

    logger.info("Voter registered successfully: {}", registeredVoter);
    return registeredVoter;
}



//http://localhost:8055/voter/id/1

    @GetMapping("/id/{id}")

    public ResponseEntity<RequiredResponse> getallDataBasedOnId(@PathVariable int id) throws NullUserFound {

        logger.info("Fetching data for ID: {}", id);

  RequiredResponse requiredResponse = new RequiredResponse();

  Voter voter = voterService.getCandidateById(id).get(id);
 requiredResponse.setVoter(voter);

        List<Candidate> listofcandidate = restTemplate.getForObject("http://CANDIDATE/voter/id/"+id, List.class);

        requiredResponse.setCandidate(listofcandidate);

 

        logger.info("Fetched data for ID: {}", id);

 

        return new ResponseEntity <RequiredResponse>(requiredResponse, HttpStatus.OK);

    }

}

//@PostMapping("/registerVoter")
//public Voter registerVoter(@RequestBody Voter voter) throws NullUserFound, NullUserNameFoundException {
	//return voterService.registerVoter(voter);
//}







//@PutMapping("/updateVoter")
//public Voter updateVoter(@RequestBody Voter voter) throws Exception {
	//return voterService.updateVoter(voter);
//}

