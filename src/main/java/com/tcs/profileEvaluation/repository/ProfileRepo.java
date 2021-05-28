package com.tcs.profileEvaluation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.profileEvaluation.entity.Profile;


public interface ProfileRepo extends JpaRepository<Profile, Integer> {
	@Query("SELECT id FROM Profile WHERE date=?1 ")
	List<Integer> findByDate(LocalDate date);
	
	@Query("SELECT id FROM Profile WHERE SUBSTR(date,6,2)=?1" )
	List<Integer> findByMonth(String date);
	
}
