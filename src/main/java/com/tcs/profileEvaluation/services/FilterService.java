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
	ProfileRepo Profilerepo;
	@Autowired
	StatusRepo checkStatus;

	public int[] getTodayProfiles(LocalDate date) {
		int[] dateFilter = new int[10];
		List<Integer> TodayProfilelist = Profilerepo.findByDate(date);
		dateFilter = Filter(TodayProfilelist);
		dateFilter[0] = TodayProfilelist.size();
		dateFilter[3] = dateFilter[0] - dateFilter[1] - dateFilter[2];
		return dateFilter;
	}

	public int[] monthProfiles(String month) {
		int[] monthFilter = new int[10];
		List<Integer> MonthProfilelist = Profilerepo.findByMonth(month);
		monthFilter = Filter(MonthProfilelist);
		monthFilter[0] = MonthProfilelist.size();
		monthFilter[3] = monthFilter[0] - monthFilter[1] - monthFilter[2];
		return monthFilter;
	}

	public int[] getAllProfileData() {
		int[] allProfiles = new int[10];
		List<Profile> profileList = Profilerepo.findAll();
		List<Integer> profileId = new ArrayList<>();
		for (Profile pro : profileList) {
			profileId.add(pro.getId());
		}

		allProfiles = Filter(profileId);
		allProfiles[0] = profileList.size();
		allProfiles[3] = allProfiles[0] - allProfiles[1] - allProfiles[2];
		return allProfiles;
	}
	public int[] Filter(List<Integer> profileId) {
		int[] FilterData = new int[10];
		int hired = 0;
		int nothired = 0;
		int junior = 0;
		int gap = 0;
		int skill = 0;
		int notavailable = 0;
		int notjoin = 0;
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
		FilterData[1] = hired;
		FilterData[2] = nothired;
		FilterData[4] = junior;
		FilterData[5] = gap;
		FilterData[6] = skill;
		FilterData[7] = notavailable;
		FilterData[8] = notjoin;
		return FilterData;
	}

}
