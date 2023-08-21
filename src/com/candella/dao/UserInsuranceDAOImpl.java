package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.Insurance;
import com.candella.entity.UserInsurance;
import com.candella.entity.UserRole;

public class UserInsuranceDAOImpl implements UserInsuranceDAO{

	private static final String userRoleId = null;

	@Override
	public void addUserInsurance(UserInsurance userInsurance) {
		try{
			Connection connection=DbConnectionPool.getDataSource().getConnection();
		
			String sql = "Insert into User_insurance( enrollment_id, user_id, plan_id, user_role_id,enrollment_date, expiry_date) VALUES ( ?,?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userInsurance.getEnrollmentId());
			statement.setString(2, userInsurance.getUserId());
			statement.setString(3, userInsurance.getInsurance().getPlanId());
			statement.setString(4, userInsurance.getUserRole().getUserRoleId());
			// Assuming the enrollmentDate is of LocalDate type
			LocalDate enrollmentDate = userInsurance.getEnrollmentDate();

			// Convert LocalDate to String in the format "yyyy-MM-dd"
			String formattedEnrollmentDate = enrollmentDate.toString();

			// Set the formatted date in the PreparedStatement
			statement.setString(5, formattedEnrollmentDate);
			LocalDate expire =userInsurance.getExpiryDate();
			String expirydate=expire.toString();
			statement.setString(6, expirydate);
			statement.executeUpdate();
			if((userInsurance.getUserRole().getUserRoleId().equalsIgnoreCase("UR001")))		
					{
				
				         addUserStudent(userInsurance.getUserId());
					}	
			else
				userInsurance.getUserRole().getUserRoleId().equalsIgnoreCase("UR002");
				{
				
				addUserStaff(userInsurance.getUserId());
			}
					
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void addUserStaff(String userId) {
		Connection connection;
		try {
			connection = DbConnectionPool.getDataSource().getConnection();
			String sql = "Insert into staff_user( staff_id,user_id) VALUES ( ?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setString(2, userId);
			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void addUserStudent(String userRoleId) {
		
		Connection connection;
		try {
			connection = DbConnectionPool.getDataSource().getConnection();
			String sql = "Insert into student_user( student_id,user_id) VALUES ( ?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userRoleId);
			statement.setString(2, userRoleId);
			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public UserInsurance getUserInsuranceById(String enrollmentId) {
	    UserInsurance userInsurance = null;
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	        String query = "SELECT * FROM User_insurance WHERE enrollment_id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, enrollmentId);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            String userId = resultSet.getString("user_id");
	            String planId = resultSet.getString("plan_id");
	            
	            // Assuming you have separate DAO classes for UserRole and Insurance entities
	            // and those classes have methods to fetch objects by their IDs.
	            // Replace the following lines with the actual method calls to fetch objects by ID.
	            UserRoleDAO userRoleDAO = new UserRoleDAOImpl(); // Replace with your actual UserRoleDAO implementation
	            UserRole userRole = userRoleDAO.getUserRoleById(resultSet.getString("user_role_id"));
	            
	            InsuranceDAO insuranceDAO = new InsuranceDAOImpl(); // Replace with your actual InsuranceDAO implementation
	            Insurance insurance = insuranceDAO.getInsurance(planId);
	            
	            LocalDate enrollmentDate = resultSet.getDate("enrollment_date").toLocalDate();
	            LocalDate expiryDate = resultSet.getDate("expiry_date").toLocalDate();

	            userInsurance = new UserInsurance(enrollmentId, userId, insurance, userRole, enrollmentDate, expiryDate);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userInsurance;
	}

	@Override
	public List<UserInsurance> viewAllUserInsurance() {
		UserRoleDAO userRoleDAO = new UserRoleDAOImpl(); 
		InsuranceDAO insuranceDAO = new InsuranceDAOImpl(); 
	    List<UserInsurance> userInsurances = new ArrayList<>();
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	        String query = "SELECT * FROM User_insurance";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            String enrollmentId = resultSet.getString("enrollment_id");
	            String userId = resultSet.getString("user_id");
	            String planId = resultSet.getString("plan_id");
	            String userRoleId = resultSet.getString("user_role_id");
	            LocalDate enrollmentDate = resultSet.getDate("enrollment_date").toLocalDate();
	            LocalDate expiryDate = resultSet.getDate("expiry_date").toLocalDate();

	            // Fetching userRole and insurance objects using their respective DAO methods
	            UserRole userRole = userRoleDAO.getUserRoleById(userRoleId);
	            Insurance insurance = insuranceDAO.getInsurance(planId);
	            
	            UserInsurance userInsurance = new UserInsurance(enrollmentId, userId, insurance, userRole, enrollmentDate, expiryDate);
	            userInsurances.add(userInsurance);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userInsurances;
	}
}

