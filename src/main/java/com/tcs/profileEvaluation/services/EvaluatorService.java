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
	EvaluatorRepo erepo;
	@Autowired
	ProfileRepo repo;
	@Autowired
	EvaluatorAssigned evalAssigned;
	@Autowired
	StatusRepo statusrepo;

	public List<Evaluator> getAllEvaluators() {
		return erepo.findAll();
	}


	public String updateprofile(Profilestatus status) {
		statusrepo.save(status);
		evalAssigned.deleteById(status.getId());
		return "status updated";
	}

	public List<Profile> getProfilesByEvaluatorId(int id) {
		List<Integer> myList1 = new ArrayList<Integer>();
		List<Evaluatorassigned> myList = new ArrayList<Evaluatorassigned>();
		System.out.println("Before mylist");
		myList = evalAssigned.findByevalid(id);
		System.out.println("After mylist"+myList);
		for (int i = 0; i < myList.size(); i++) {
			myList1.add(myList.get(i).getId());
		}
		if (myList1.isEmpty()) {
			return null;
		} else {
			return repo.findAllById(myList1);
		}
	}
	
	public String updateEvaluator(EvaluatorAssignedPo eval) {
		Evaluatorassigned evaluatorAssi = new Evaluatorassigned();
		evaluatorAssi.setEvalname(eval.getEvalname());
		evaluatorAssi.setEvalid(eval.getEvalid());
		evaluatorAssi.setId(eval.getId());

		evalAssigned.save(evaluatorAssi);
		return "Evaluator Assigned";
	}
}
