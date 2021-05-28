package com.tcs.profileEvaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.profileEvaluation.entity.Evaluator;

public interface EvaluatorRepo extends JpaRepository<Evaluator, Integer>{

}
