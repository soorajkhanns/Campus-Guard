package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.Staff;

public class StaffDAOImpl implements StaffDAO {

	
	@Override
	public void addStaff(Staff staff) {
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	        String sql = "INSERT INTO staff (Staff_id, Staff_name, Staff_address, dob, gender, blood_group, phone_no) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, staff.getStaffId());
	        statement.setString(2, staff.getStaffName());
	        statement.setString(3, staff.getStaffAddress());
	        statement.setObject(4, staff.getDob());
	        statement.setString(5, staff.getGender());
	        statement.setString(6, staff.getBloodGroup());
	        statement.setLong(7, staff.getPhoneNo());

	        // Execute the SQL INSERT statement
	        statement.executeUpdate();
	    } catch (Exception e) {
	        // Handle any exceptions that might occur during database insertion
	        System.out.println(  e.getMessage());
	    }
	}

		
	

	@Override
	public Staff getstaff(String staffId) {
		Staff staff = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try (Connection connection = DbConnectionPool.getDataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM staff WHERE student_id = ?")) {

			preparedStatement.setString(1, staffId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Create a Student object and set its attributes from the result set
				staff = new Staff();
				staff.setStaffId(resultSet.getString("staff_id"));
				staff.setStaffName(resultSet.getString("staff_name"));
				staff.setStaffAddress(resultSet.getString("staff_address"));

				// Parse the date string to LocalDate using the formatter
				LocalDate dob = LocalDate.parse(resultSet.getString("dob"), formatter);
				staff.setDob(dob);
				staff.setGender(resultSet.getString("gender"));
				staff.setBloodGroup(resultSet.getString("blood_group"));
				staff.setPhoneNo(resultSet.getLong("phone_No"));
			}

		} catch (SQLException e) {
			// Handle the exception or log the error
			e.printStackTrace();
		}

		return staff;
	}

	@Override
	public void updateStaff(String staffId, String column) {
		try {
			Scanner scanner = new Scanner(System.in);
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String tableName = "staff";

			System.out.println("updated data is-:");
			String data = scanner.nextLine();

			String condition = "staff_id = ?";
			String updatequery = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + condition;

			PreparedStatement statement = connection.prepareStatement(updatequery);
			statement.setString(1, data);
			statement.setString(2, staffId);

			statement.executeUpdate();

		} catch (Exception e) {
			// Handle any exceptions that might occur during database insertion
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Staff> viewAllStaff() {
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Staff> staffList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String query="select *from staff";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				String id=resultSet.getString(1);
				String name=resultSet.getString(2);
				String address=resultSet.getString(3);
				LocalDate dob=LocalDate.parse(resultSet.getString(4),formatter);
				String gender=resultSet.getString(5);
				String bg=resultSet.getString(6);
				Long phoneNo=resultSet.getLong(7);
				
				Staff staff =new Staff(id,name,address,dob,gender,bg,phoneNo);
				
				staffList.add(staff);
				
				
			}
			

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		return staffList;
	}

}
