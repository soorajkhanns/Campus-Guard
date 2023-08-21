package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.UserInsurance;
import com.candella.entity.UserPayment;
import com.candella.entity.UserRole;

public class UserPaymentDAOImpl implements UserPaymentDAO {

    @Override
    public void addUserPayment(UserPayment userPayment) {
        try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
            String sql = "INSERT INTO User_payment(payment_id, enrollment_id, payment_date, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userPayment.getPaymentId());
            statement.setString(2, userPayment.getUserInsurance().getEnrollmentId());
            statement.setString(3, userPayment.getPaymentDate().toString());
            statement.setDouble(4, userPayment.getAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserPayment getUserPaymentById(String paymentId) {
        UserPayment userPayment = null;
        try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
            String query = "SELECT * FROM User_payment WHERE payment_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, paymentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserRoleDAO userRoleDAO = new UserRoleDAOImpl(); // Replace with your actual UserRoleDAO implementation
                String enrollmentId = resultSet.getString("enrollment_id");
                UserInsurance userInsurance=new UserInsurance();
                userInsurance.setEnrollmentId(enrollmentId);
                UserRole userRole = userRoleDAO.getUserRoleById(resultSet.getString("user_role_id"));
                LocalDate paymentDate = resultSet.getDate("payment_date").toLocalDate();
                double amount = resultSet.getDouble("amount");
                userPayment = new UserPayment(paymentId, userInsurance, userRole, paymentDate, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPayment;
    }

    @Override
    public List<UserPayment> viewAllUserPayments() {
        List<UserPayment> userPayments = new ArrayList<>();
        try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
            String query = "SELECT * FROM User_payment";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String paymentId = resultSet.getString("payment_id");
                UserRoleDAO userRoleDAO = new UserRoleDAOImpl(); // Replace with your actual UserRoleDAO implementation
                UserRole userRole = userRoleDAO.getUserRoleById(resultSet.getString("user_role_id"));
                String enrollmentId = resultSet.getString("enrollment_id");
                UserInsurance userInsurance=new UserInsurance();
                userInsurance.setEnrollmentId(enrollmentId);
                LocalDate paymentDate = resultSet.getDate("payment_date").toLocalDate();
                double amount = resultSet.getDouble("amount");
                UserPayment userPayment = new UserPayment(paymentId, userInsurance, userRole, paymentDate, amount);
                userPayments.add(userPayment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPayments;
    }
}
