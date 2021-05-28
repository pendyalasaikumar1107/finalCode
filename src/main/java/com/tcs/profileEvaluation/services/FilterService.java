package com.tcs.profileEvaluation.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profileEvaluation.entity.Profile;
import com.tcs.profileEvaluation.entity.Profilestatus;
import com.tcs.profileEvaluation.repository.ProfileRepo;
import com.tcs.profileEvaluation.repository.StatusRepo;

@Service
public class FilterService {

	@Autowired
	ProfileRepo repo;
	@Autowired
	StatusRepo checkStatus;

	public int[] getTodayProfiles(LocalDate date) {
		// TODO Auto-generated method stub
		int[] dateFilter = new int[10];
		int hired = 0;
		int nothired = 0;
		int junior = 0;
		int gap = 0;
		int skill = 0;
		int notavailable = 0;
		int notjoin = 0;
		List<Integer> list = repo.findByDate(date);
		dateFilter[0] = list.size();
		List<Profilestatus> listStatus = checkStatus.findAllById(list);
		for (Profilestatus profilestatus : listStatus) {
			if (profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if (profilestatus.getStatus().equalsIgnoreCase("not hired")) {
				nothired++;
				if (profilestatus.getComments().equalsIgnoreCase("Too junior")) {
					junior++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("Competency gap")) {
					gap++;

				}
				if (profilestatus.getComments().equalsIgnoreCase("Skills mismatch")) {
					skill++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("not Available")) {
					notavailable++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("Associate not willing to Join")) {
					notjoin++;
				}
			}
		}
		dateFilter[1] = hired;
		dateFilter[2] = nothired;
		dateFilter[3] = dateFilter[0] - dateFilter[1] - dateFilter[2];
		dateFilter[4] = junior;
		dateFilter[5] = gap;
		dateFilter[6] = skill;
		dateFilter[7] = notavailable;
		dateFilter[8] = notjoin;
		return dateFilter;
	}

	public int[] monthProfiles(String month) {
		// TODO Auto-generated method stub
		int[] monthFilter = new int[10];
		int hired = 0;
		int nothired = 0;
		int junior = 0;
		int gap = 0;
		int skill = 0;
		int notavailable = 0;
		int notjoin = 0;
		List<Integer> list = repo.findByMonth(month);
		monthFilter[0] = list.size();
		List<Profilestatus> listStatus = checkStatus.findAllById(list);
		for (Profilestatus profilestatus : listStatus) {
			if (profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if (profilestatus.getStatus().equalsIgnoreCase("not hired")) {
				nothired++;
				if (profilestatus.getComments().equalsIgnoreCase("Too junior")) {
					junior++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("Competency gap")) {
					gap++;

				}
				if (profilestatus.getComments().equalsIgnoreCase("Skills mismatch")) {
					skill++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("not Available")) {
					notavailable++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("Associate not willing to Join")) {
					notjoin++;
				}
			}
		}
		monthFilter[1] = hired;
		monthFilter[2] = nothired;
		monthFilter[3] = monthFilter[0] - monthFilter[1] - monthFilter[2];
		monthFilter[4] = junior;
		monthFilter[5] = gap;
		monthFilter[6] = skill;
		monthFilter[7] = notavailable;
		monthFilter[8] = notjoin;
		return monthFilter;
	}

	public int[] getAllProfileData() {
		int[] allProfiles = new int[9];
		int hired = 0;
		int nothired = 0;
		int junior = 0;
		int gap = 0;
		int skill = 0;
		int notavailable = 0;
		int notjoin = 0;
		List<Profile> list = repo.findAll();
		allProfiles[0] = list.size();
		List<Integer> profileId = new ArrayList<>();
		for (Profile pro : list) {
			profileId.add(pro.getId());
		}
		List<Profilestatus> listStatus = checkStatus.findAllById(profileId);
		for (Profilestatus profilestatus : listStatus) {
			if (profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if (profilestatus.getStatus().equalsIgnoreCase("not hired")) {
				nothired++;
				if (profilestatus.getComments().equalsIgnoreCase("Too junior")) {
					junior++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("Competency gap")) {
					gap++;

				}
				if (profilestatus.getComments().equalsIgnoreCase("Skills mismatch")) {
					skill++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("not Available")) {
					notavailable++;
				}
				if (profilestatus.getComments().equalsIgnoreCase("Associate not willing to Join")) {
					notjoin++;
				}
			}
		}
		allProfiles[1] = hired;
		allProfiles[2] = nothired;
		allProfiles[3] = allProfiles[0] - allProfiles[1] - allProfiles[2];
		allProfiles[4] = junior;
		allProfiles[5] = gap;
		allProfiles[6] = skill;
		allProfiles[7] = notavailable;
		allProfiles[8] = notjoin;
		return allProfiles;
	}

}
