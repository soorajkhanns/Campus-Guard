package com.candella.service;

import java.util.List;

import com.candella.entity.Staff;

public interface StaffService {

    void addStaff(Staff staff);
     Staff getstaff(String staffId);
	void updateStaff(String staffId, String column);
	List<Staff> viewAllStaff();
	
}


