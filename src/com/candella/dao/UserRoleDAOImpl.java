package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.UserRole;

public class UserRoleDAOImpl implements UserRoleDAO {

    @Override
    public UserRole getUserRoleById(String userRoleId) {
        UserRole userRole = null;

        try (Connection connection = DbConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_role WHERE user_role_id = ?")) {

            preparedStatement.setString(1, userRoleId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Create a UserRole object and set its attributes from the result set
                userRole = new UserRole();
                userRole.setUserRoleId(resultSet.getString("user_role_id"));
                userRole.setUserType(resultSet.getString("user_type"));
            }

        } catch (SQLException e) {
            // Handle the exception or log the error
            e.printStackTrace();
        }

        return userRole;
    }

	@Override
	public List<UserRole> getUserRole() {
		 List<UserRole> userRoles = new ArrayList<>();

	        try (Connection connection = DbConnectionPool.getDataSource().getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_role")) {

	          
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                // Create a UserRole object and set its attributes from the result set
	                UserRole userRole = new UserRole();
	                userRole.setUserRoleId(resultSet.getString("user_role_id"));
	                userRole.setUserType(resultSet.getString("user_type"));
	                userRoles.add(userRole);
	            }

	        } catch (SQLException e) {
	            // Handle the exception or log the error
	            e.printStackTrace();
	        }

	        return userRoles;
	}
}