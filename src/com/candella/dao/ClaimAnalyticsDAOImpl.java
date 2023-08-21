package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.ClaimAnalytics;
import com.candella.entity.UserClaims;

 public class ClaimAnalyticsDAOImpl implements ClaimAnalyticsDAO {

  

	@Override
     public List<ClaimAnalytics> viewClaimAnalyticsByClaimId(String claimId) {
         List<ClaimAnalytics> claimAnalyticsList = new ArrayList<>();
         UserClaimDAOImpl userclaimDAOImpl = new UserClaimDAOImpl();
         try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
             String query = "SELECT * FROM user_claims WHERE claim_id = ?";
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, claimId);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                
                 String claimType = resultSet.getString("claim_type");
                 String claimStatus = resultSet.getString("claim_status");
                 int claimPercentage = resultSet.getInt("claim_percentage");
                 

                 UserClaims userClaim = userclaimDAOImpl.getUserClaimsById(claimId); // Retrieve UserClaims

                 ClaimAnalytics claimAnalytics = new ClaimAnalytics( userClaim, claimType, claimStatus, claimPercentage);
                 claimAnalyticsList.add(claimAnalytics);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return claimAnalyticsList;
     }

     


	 @Override
	    public ClaimAnalytics getClaimAnalyticsById(UserClaims claimId) {
	        ClaimAnalytics claimAnalytics = null;
	        try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	            String query = "SELECT * FROM Claim_analytics WHERE claim_id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, claimId.getClaimId());
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                int analyticsId = resultSet.getInt("analytics_id");
	                String claimType = resultSet.getString("claim_type");
	                String claimStatus = resultSet.getString("claim_status");
	                int claimPercentage = resultSet.getInt("claim_percentage");

	                claimAnalytics = new ClaimAnalytics( claimId, claimType, claimStatus, claimPercentage);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return claimAnalytics;
	    }
	 public double calculateAverageClaimPercentageForPlan(String planId) {
	        double totalClaimPercentage = 0;
	        int rowCount = 0;

	        try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
	            String query = "SELECT ua.claim_percentage " +
	                           "FROM claim_analytics ua " +
	                           "JOIN user_claims uc ON ua.claim_id = uc.claim_id " +
	                           "JOIN user_insurance ui ON uc.enrollment_id = ui.enrollment_id " +
	                           "WHERE ui.plan_id = ?";
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, planId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int claimPercentage = resultSet.getInt("claim_percentage");
	                totalClaimPercentage += claimPercentage;
	                rowCount++;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        if (rowCount > 0) {
	            return totalClaimPercentage / rowCount;
	        } else {
	            return 0.0; // No data found
	        }
	    }


	@Override
	public void addClaimAnalytics(ClaimAnalytics claimAnalytics) {
		// TODO Auto-generated method stub
		
	}
    
}
