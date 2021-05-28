package com.tcs.profileEvaluation.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profileEvaluation.entity.Evaluatorassigned;
import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.po.EvaluatorAssignedPo;
import com.tcs.profileEvaluation.repository.Evaluator_Assigned;
import com.tcs.profileEvaluation.repository.ProfileRepo;

@Service
public class LeadService {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ProfileRepo prepo;

	public List<Profile> getAllProfile() {
		return prepo.findAll();
	}

	@Autowired
	Evaluator_Assigned evaluator;

	public String updateEvaluator(EvaluatorAssignedPo eval) {
		Evaluatorassigned evaluatorAssigned = new Evaluatorassigned();
		evaluatorAssigned.setEvalname(eval.getEvalname());
		evaluatorAssigned.setEvalid(eval.getEvalid());
		evaluatorAssigned.setId(eval.getId());

		evaluator.save(evaluatorAssigned);
		return "Evaluator Assigned";
	}

}
