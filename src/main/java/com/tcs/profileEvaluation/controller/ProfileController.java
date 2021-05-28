package com.tcs.profileEvaluation.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.profileEvaluation.po.EvaluatorAssignedPo;
import com.tcs.profileEvaluation.services.LeadService;

@RestController
@CrossOrigin
public class ProfileController {

	@Autowired
	LeadService leadService;
	@PutMapping("/updateProfile")
	public String putEvaluator(@Valid @RequestBody EvaluatorAssignedPo eval) {
		
		return leadService.updateEvaluator(eval);
		
	}
}
