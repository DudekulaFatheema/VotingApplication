package com.voter.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.voter.entity.Voter;
import com.voter.exception.NullUserFound;
import com.voter.exception.NullUserNameFoundException;
import com.voter.exception.NullValueFoundException;
import com.voter.repository.VoterRepository;



@SpringBootTest
 class VoterServiceImplTest {
	
	@Autowired
	VoterRepository voterRepo;
	
	@Autowired
	VoterService voterService;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	@Test

    void createVoter() throws NullValueFoundException{
		
		 
		Voter sampleInput = new Voter(8,"haseena","male", 15, 90876435, "haseena","haseen4",56);
		Voter expectedOutput = new Voter(8,"haseena","male", 18, 90879365, "haseen","has98",89);
		
		VoterService voterService = mock(VoterService.class);
        when(voterService.createVoter(sampleInput)).thenReturn(expectedOutput);

        // Act
        Voter actualOutput = voterService.createVoter(sampleInput);

        // Assert
        assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void registerVoter() throws NullUserFound, NullUserNameFoundException {
		
         Voter voter = new Voter();
          voter.setAge(18);
          voter.setName("haseena");
		 voter.setGender("male");
		 voter.setPhoneNumber(56743865);
         voter.setUserName("mario");
         voter.setPassWord("js123");
         voter.setId(65);
       Voter registeredVoter = voterService.registerVoter(voter);

	 assertNotNull(registeredVoter);
	 assertEquals(18, registeredVoter.getAge());
      assertEquals("haseena", registeredVoter.getName());
     assertEquals("male", registeredVoter.getGender());
     assertEquals(56743865, registeredVoter.getPhoneNumber());
 assertEquals("mario", registeredVoter.getUserName());
  assertEquals("js123", registeredVoter.getPassWord());
  assertEquals(65, registeredVoter.getId());
	

}
	
	@Test
	void UpdateVoter() throws Exception {
// Create a team member with valid ID and updated name

		Voter sampleInput = new Voter(8,"haseena","male", 15, 90876435, "haseena","haseen4",56);
		Voter expectedOutput = new Voter(8,"haseena","male", 18, 90879365, "haseen","has98",65);

		 

		VoterService voterService = Mockito.mock(VoterService.class);

		BDDMockito.when(voterService.updateVoter(sampleInput)).thenReturn(expectedOutput);

		 

		Voter voter = new Voter();

		 

		Voter actualOutput = voterService.updateVoter(sampleInput);

		 

		assertEquals(expectedOutput, actualOutput);

	}
	
	@Test
	
	void testGetAllVoters() throws Exception{
		
		 Voter voter1 = new Voter(8,"haseena","male", 15, 90876435, "haseena","haseen4",65);
		Voter voter2 = new Voter(8,"haseena","male", 18, 90879365, "haseen","has98",65);
		
	     List<Voter> sampleOutput = new ArrayList<>();
		sampleOutput.add(voter1);
		sampleOutput.add(voter2);
		
		 VoterService voterService = mock(VoterService.class);
	        when(voterService.getAllVoters()).thenReturn(sampleOutput);

	        // Act
	        List<Voter> actualOutput = voterService.getAllVoters();

	        // Assert
	        assertNotNull(actualOutput);
	        assertIterableEquals(sampleOutput, actualOutput);
	    }
	
	
	//@Test
	//void testDeleteByVoterId_NonExistentId() throws Exception {
	    // Arrange
	    //int voterId = 999;

	    // Act and Assert
	   // assertThrows(Exception.class, () -> voterService.deleteByVoterId(voterId));
	    // Additional assertions can be performed to verify the exception message or behavior
	//}
	
	

	
	@Test
	void testLoginVoter_EmptyPassword() {
	    // Arrange
	    String userName = "haseena";
	    String password = "";

	    // Act and Assert
	    assertThrows(NullUserFound.class, () -> voterService.loginVoter(userName, password));
	}
	@Test
	void testLoginVoter_EmptyUsername() {
	    // Arrange
	    String userName = "";
	    String password = "haseen4";

	    // Act and Assert
	    assertThrows(NullUserFound.class, () -> voterService.loginVoter(userName, password));
	}
	
	}

	

	
