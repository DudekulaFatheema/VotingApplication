package com.voter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voter.entity.Voter;
@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {

	
	@Query("from Voter v where v.voterId=:voterId")
	public Voter getByVoterId(@Param(value="voterId")int voterId );
	
	@Query("from Voter v where v.userName=:userName and v.passWord=:passWord")
	public Voter findVoterByuserNamepassWord(@Param(value="userName") String userName, @Param(value="passWord")String passWord);

	 public List<Voter> getCandidateById(int id);
		
	
}