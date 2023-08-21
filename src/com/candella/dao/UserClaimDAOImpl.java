package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.UserClaims;
import com.candella.entity.UserInsurance;

public class UserClaimDAOImpl implements UserClaimDAO {
	
	

	@Override
	public void addUserClaim(UserClaims userclaim) {
		try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
			String sql = "INSERT INTO User_claims(claim_id, enrollment_id, claim_date, claim_description, claim_amount, disbursement_date, bill_amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userclaim.getClaimId());
			statement.setString(2, userclaim.getUserInsurance().getEnrollmentId());
			statement.setString(3, userclaim.getClaimDate().toString());
			statement.setString(4, userclaim.getClaimDescription());
			statement.setDouble(5, userclaim.getClaimAmount());
			statement.setString(6, userclaim.getDisbursementDate().toString());
			statement.setDouble(7, userclaim.getBillAmount());
			int  result=statement.executeUpdate();
			if(result!=0)
			{
				statement=connection.prepareStatement("insert into claim_analytics(claim_id,claim_type,claim_status,claim_percentage) values(?,?,?,?)");
				statement.setString(1, userclaim.getClaimId());
				statement.setString(2, userclaim.getClaimDescription());
				statement.setString(3,"Approved");
				int percentage = 0;
				if(userclaim.getClaimAmount()<=userclaim.getBillAmount())
				{
				percentage=(int) ((userclaim.getClaimAmount()/userclaim.getBillAmount())*100);
				}
				else
				{
					percentage=100;
				}
				statement.setInt(4,percentage);
				statement.executeUpdate();
			}
			connection.close();
			
			

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserClaims getUserClaimsById(String claimId) {
		UserClaims userClaim = null;
		try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
			String query = "SELECT * FROM User_claims WHERE claim_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, claimId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String enrollmentId = resultSet.getString("enrollment_id");
				UserInsurance userInsurance = new UserInsurance();
				userInsurance.setEnrollmentId(enrollmentId);
				String description = resultSet.getString("claim_description");
				LocalDate claimDate = resultSet.getDate("claim_date").toLocalDate();
				double amount = resultSet.getDouble("claim_amount");
				LocalDate disbursement = resultSet.getDate("disbursement_date").toLocalDate();
				double billamount = resultSet.getDouble("bill_amount");

				userClaim = new UserClaims(claimId, userInsurance, claimDate, description, amount, billamount,
						disbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userClaim;
	}

	@Override
	public List<UserClaims> viewAllUserClaims() {
		List<UserClaims> userClaimsList = new ArrayList<>();
		try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
			String query = "SELECT * FROM User_Claims";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String claimId = resultSet.getString("claim_id");
				String enrollmentId = resultSet.getString("enrollment_id");
				UserInsurance userInsurance = new UserInsurance();
				userInsurance.setEnrollmentId(enrollmentId);
				String description = resultSet.getString("claim_description");
				LocalDate claimDate = resultSet.getDate("claim_date").toLocalDate();
				double amount = resultSet.getDouble("claim_amount");
				double billamount = resultSet.getDouble("bill_amount");
				LocalDate disbursement = resultSet.getDate("disbursement_date").toLocalDate();

				UserClaims userClaims = new UserClaims(claimId, userInsurance, claimDate, description, amount,
						billamount, disbursement); // You need to define UserClaims constructor accordingly
				userClaimsList.add(userClaims);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userClaimsList;
	}
}
