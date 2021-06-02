package com.tcs.profileEvaluation.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.po.Profilepo;
import com.tcs.profileEvaluation.repository.ProfileRepo;

@Service
public class ProfileService {
	@Autowired
	ProfileRepo Profilerepo;

	public String addProfile(Profilepo profilepo) {
		var profile = new Profile();
		profile.setId(profilepo.getId());
		profile.setName(profilepo.getName());
		profile.setExperience(profilepo.getExperience());
		profile.setLocation(profilepo.getLocation());
		profile.setMobileno(profilepo.getMobileno());
		profile.setSkill1(profilepo.getSkill1());
		profile.setSkill2(profilepo.getSkill2());
		profile.setVendor(profilepo.getVendor());
		profile.setDate(java.time.LocalDate.now());

		if (profile.getId() == 0) {
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			profile.setId(number);
		}

		if (Profilerepo.existsById(profile.getId())) {
			return "Sorry";
		} else {
			Profilerepo.save(profile);
			return "success";
		}
	}

	public List<Profile> getAllProfile() {
		return Profilerepo.findAll();
	}

	public String uploadFile(Profile[] profilearr) {
		Profile[] profileList =  profilearr;
		for(Profile prof: profileList) {
			var profile = new Profile();
			profile.setId(prof.getId());
			profile.setName(prof.getName());
			profile.setExperience(prof.getExperience());
			profile.setLocation(prof.getLocation());
			profile.setMobileno(prof.getMobileno());
			profile.setSkill1(prof.getSkill1());
			profile.setSkill2(prof.getSkill2());
			profile.setVendor(prof.getVendor());
			profile.setDate(java.time.LocalDate.now());
			if (prof.getId() == 0) {
				Random rnd = new Random();
				int number = rnd.nextInt(999999);
				profile.setId(number);
			}
			if(prof.getId() != 0 && !Profilerepo.existsById(prof.getId())) {
				Profilerepo.save(profile);
			}
		}
		return "File Uploaded Successfully";
	}
}
