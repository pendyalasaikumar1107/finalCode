package com.tcs.profileEvaluation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.profileEvaluation.entity.Evaluator;
import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.repository.StatusRepo;
import com.tcs.profileEvaluation.services.EvaluatorService;

@RestController
@CrossOrigin
public class EvaluatorController {
	@Autowired
	StatusRepo statusrepo;
	@Autowired
	EvaluatorService eservice;

	@GetMapping("/evaluator/{id}")
	public List<Profile> getProfilesByEvaluatorId(@PathVariable int id) {
		System.out.println(id);
		return eservice.getProfilesByEvaluatorId(id);

	}

	@GetMapping("/getEvaluators")
	public List<Evaluator> getAllEvaluators() {
		return eservice.getAllEvaluators();
	}

	
}
