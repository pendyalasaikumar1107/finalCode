package com.tcs.profileEvaluation.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profileEvaluation.entity.Evaluator;
import com.tcs.profileEvaluation.entity.Evaluatorassigned;
import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.entity.Profilestatus;
import com.tcs.profileEvaluation.po.EvaluatorAssignedPo;
import com.tcs.profileEvaluation.repository.EvaluatorAssigned;
import com.tcs.profileEvaluation.repository.EvaluatorRepo;
import com.tcs.profileEvaluation.repository.ProfileRepo;
import com.tcs.profileEvaluation.repository.StatusRepo;

@Service
public class EvaluatorService {

	@Autowired
	EvaluatorRepo evaluatorrepo;
	@Autowired
	ProfileRepo Profilerepo;
	@Autowired
	EvaluatorAssigned evalAssigned;
	@Autowired
	StatusRepo statusrepo;

	public List<Evaluator> getAllEvaluators() {
		return evaluatorrepo.findAll();
	}

	public String updateprofile(Profilestatus status) {
		statusrepo.save(status);
		evalAssigned.deleteById(status.getId());
		return "status updated";
	}

	public List<Profile> getProfilesByEvaluatorId(int id) {
		List<Integer> evaluatorProfiles = new ArrayList<Integer>();
		List<Evaluatorassigned> evaluatorList = new ArrayList<Evaluatorassigned>();
		System.out.println("Before mylist");
		evaluatorList = evalAssigned.findByevalid(id);
		System.out.println("After mylist" + evaluatorList);
		for (int i = 0; i < evaluatorList.size(); i++) {
			evaluatorProfiles.add(evaluatorList.get(i).getId());
		}
		if (evaluatorProfiles.isEmpty()) {
			return null;
		} else {
			return Profilerepo.findAllById(evaluatorProfiles);
		}
	}

	public String updateEvaluator(EvaluatorAssignedPo eval) {
		Evaluatorassigned evaluatorAssigned = new Evaluatorassigned();
		evaluatorAssigned.setEvalname(eval.getEvalname());
		evaluatorAssigned.setEvalid(eval.getEvalid());
		evaluatorAssigned.setId(eval.getId());

		evalAssigned.save(evaluatorAssigned);
		return "Evaluator Assigned";
	}
}
