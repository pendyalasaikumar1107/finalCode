package com.tcs.profileEvaluation.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profileEvaluation.entity.Evaluator;
import com.tcs.profileEvaluation.entity.Evaluatorassigned;
import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.entity.Profilestatus;
import com.tcs.profileEvaluation.repository.EvaluatorRepo;
import com.tcs.profileEvaluation.repository.Evaluator_Assigned;
import com.tcs.profileEvaluation.repository.ProfileRepo;
import com.tcs.profileEvaluation.repository.StatusRepo;

@Service
public class EvaluatorService {

	@Autowired
	EvaluatorRepo erepo;

	public List<Evaluator> getAllEvaluators() {
		return erepo.findAll();
	}

	@Autowired
	ProfileRepo repo;
	Evaluator_Assigned evalAssigned;
	@Autowired
	StatusRepo statusrepo;

	public String updateprofile(Profilestatus status) {
		statusrepo.save(status);
		evalAssigned.deleteById(status.getId());
		return "status updated";
	}

	public List<Profile> getProfilesByEvaluatorId(int id) {
		List<Integer> myList1 = new ArrayList<Integer>();
		List<Evaluatorassigned> myList = new ArrayList<Evaluatorassigned>();
		myList = evalAssigned.findByevalid(id);
		for (int i = 0; i < myList.size(); i++) {
			myList1.add(myList.get(i).getId());
		}
		if (myList1.isEmpty()) {
			return null;
		} else {
			return repo.findAllById(myList1);
		}
	}
}
