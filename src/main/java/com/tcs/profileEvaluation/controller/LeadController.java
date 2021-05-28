package com.tcs.profileEvaluation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.repository.Evaluator_Assigned;
import com.tcs.profileEvaluation.repository.ProfileRepo;
import com.tcs.profileEvaluation.repository.StatusRepo;
import com.tcs.profileEvaluation.services.LeadService;

@RestController
@CrossOrigin
@Repository
public class LeadController {
	
	@Autowired
	ProfileRepo repo;
	@Autowired
	LeadService leadService;
	@Autowired
	Evaluator_Assigned evalRepo;
	@Autowired
	StatusRepo checkStatus;
	
	@GetMapping("/getProfiles")
	public List<Profile> getData() {
		return leadService.getAllProfile();
	}
}
	
	
	
