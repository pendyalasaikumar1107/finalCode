package com.tcs.profileEvaluation.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.profileEvaluation.services.FilterService;

@RestController
@CrossOrigin
public class FilterController {
	@Autowired
	FilterService fservice;
	
	@GetMapping("/date")
	public int[] profileWithDate(){
		LocalDate	date = java.time.LocalDate.now();
		return fservice.getTodayProfiles(date);
	}
	
	@GetMapping("/month/{month}")
	public int[] profileWithMonth(@PathVariable String month){
		return fservice.monthProfiles(month);
	}
	
	@GetMapping("/allTimeFilter")
	public int[] getAllProfileData() {
		return fservice.getAllProfileData();
	}

}
