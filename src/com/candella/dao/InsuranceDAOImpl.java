package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.Insurance;
import com.candella.entity.Student;

public class InsuranceDAOImpl implements InsuranceDAO {

	@Override
	public void addInsurance(Insurance insurance) {
	    try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	        String sql = "INSERT INTO insurance VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, insurance.getPlanId());
	        statement.setString(2, insurance.getPlanName());
	        statement.setString(3, insurance.getDescription());
	        statement.setLong(4, insurance.getCoverage()); // Set the coverage value
	        statement.setLong(5, insurance.getAmount());
	        statement.setDouble(6, insurance.getCoverageLimit());
	        statement.setInt(7, insurance.getAgeLimit());

	        // Execute the SQL INSERT statement
	        statement.executeUpdate();
	    } catch (Exception e) {
	        // Handle any exceptions that might occur during database insertion
	        System.out.println("An error occurred while adding the insurance: " + e.getMessage());
	    }
	}


	@Override
	public Insurance getInsurance(String planId) {
		Insurance insurance = null;
		

		try (Connection connection = DbConnectionPool.getDataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM insurance WHERE plan_id = ?")) {

			preparedStatement.setString(1, planId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Create a Student object and set its attributes from the result set
				insurance = new Insurance();
			
				insurance.setPlanId(resultSet.getString("plan_id"));
				insurance.setPlanName(resultSet.getString("plan_name"));
				insurance.setDescription(resultSet.getString("description"));

				// Parse the date string to LocalDate using the formatter
				
				
				insurance.setCoverage(resultSet.getLong("coverage"));
				insurance.setAmount(resultSet.getLong("amount"));
				insurance.setCoverageLimit(resultSet.getLong("coverage_limit"));
				insurance.setAgeLimit(resultSet.getInt("age_limit"));
			}

		} catch (SQLException e) {
			// Handle the exception or log the error
			e.printStackTrace();
		
	}
		return insurance;
		}

	@Override
	public void updateInsurance(String planId, String column) {
		try {
			Scanner scanner = new Scanner(System.in);
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String tableName = "insurance";

			System.out.println("updated data is-:");
			String data = scanner.nextLine();

			String condition = "plan_id = ?";
			String updatequery = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + condition;

			PreparedStatement statement = connection.prepareStatement(updatequery);
			statement.setString(1, data);
			statement.setString(2, planId);

			statement.executeUpdate();

		} catch (Exception e) {
			// Handle any exceptions that might occur during database insertion
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Insurance> viewAllInsurance() {
		List<Insurance> insuranceList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String query="select *from insurance";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				String id=resultSet.getString(1);
				String name=resultSet.getString(2);
				String description=resultSet.getString(3);
				
				long coverage=resultSet.getLong(5);
				long amount=resultSet.getLong(6);
				Long climit=resultSet.getLong(7);
				int agelimit=resultSet.getInt(7);
				
				Insurance insu =new Insurance(id,name,description,coverage,amount,climit,agelimit);
				
				insuranceList.add(insu);
				
				
			}
		}

			catch(Exception e){
				System.out.println(e.getMessage());
				
			}
			return insuranceList;
		}
	

		}




