package com.tcs.profileEvaluation.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.JoinColumn;

@Entity
public class Profile {
	@Id
	private int id;
	private String vendor;
	private String name;
	private Long mobileno;
	private String location;
	private Float experience;
	private String skill1;
	private String skill2;
	private LocalDate date;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Profilestatus status;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Evaluatorassigned evalassigned;

	public Evaluatorassigned getEvalassigned() {
		return evalassigned;
	}

	public void setEvalassigned(Evaluatorassigned evalassigned) {
		this.evalassigned = evalassigned;
	}

	public Profilestatus getStatus() {
		return status;
	}

	public void setStatus(Profilestatus status) {
		this.status = status;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long long1) {
		this.mobileno = long1;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getExperience() {
		return experience;
	}

	public void setExperience(Float experience) {
		this.experience = experience;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}