package com.tcs.profileEvaluation.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.entity.Profilestatus;
import com.tcs.profileEvaluation.po.EvaluatorAssignedPo;
import com.tcs.profileEvaluation.po.Profilepo;
import com.tcs.profileEvaluation.services.EvaluatorService;
import com.tcs.profileEvaluation.services.ProfileService;
@RestController
@CrossOrigin
public class ProfileController {

	@Autowired
	ProfileService profileService;
	@Autowired
	EvaluatorService eservice;
	
	
	@PostMapping("/addProfile")
	public String addProfile(@Valid @RequestBody Profilepo profilepo) {
		return profileService.addProfile(profilepo);
		
	}
	
	@GetMapping("/getProfiles")
	public List<Profile> getData() {
		return profileService.getAllProfile();
	}
	
	@PutMapping("/updateProfile")
	public String putEvaluator(@Valid @RequestBody EvaluatorAssignedPo eval) {
		return eservice.updateEvaluator(eval);
	}
	
	@PutMapping("/statusupdate")
	public String updateprofile(@RequestBody Profilestatus status) {
		return eservice.updateprofile(status);
	}
}
