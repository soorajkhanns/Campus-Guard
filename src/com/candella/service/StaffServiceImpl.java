package com.candella.service;

import java.util.List;

import com.candella.dao.StaffDAO;
import com.candella.dao.StaffDAOImpl;
import com.candella.entity.Staff;

public class StaffServiceImpl implements StaffService {

	 private StaffDAO staffDAO;

	    public StaffServiceImpl() {
	        // Initialize the DAO implementation
	        staffDAO = new StaffDAOImpl();
	    }

	    @Override
	    public void addStaff(Staff staff) {
	        staffDAO.addStaff(staff);
	    }

		@Override
		public void updateStaff(String staffId, String column) {
		
			staffDAO.updateStaff(staffId,column);
		}

		@Override
		public List<Staff> viewAllStaff() {
			
			return staffDAO.viewAllStaff();
		}

		@Override
		public Staff getstaff(String staffId) {
			// TODO Auto-generated method stub
			 return staffDAO.getstaff(staffId);
		}
		


}
