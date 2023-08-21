package com.candella.dao;

import java.util.List;

import com.candella.entity.Staff;

public interface StaffDAO {

    void addStaff(Staff staff);
     Staff getstaff(String staffId);
	void updateStaff(String staffId, String column);
	List<Staff> viewAllStaff();
	
}


