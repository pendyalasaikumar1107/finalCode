package com.tcs.profileEvaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.profileEvaluation.entity.Profilestatus;

public interface StatusRepo extends JpaRepository<Profilestatus, Integer> {

}
