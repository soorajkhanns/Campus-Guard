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
import javax.swing.text.DateFormatter;

import com.candella.dbconnection.DbConnectionPool;
import com.candella.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	@Override
	public void addStudent(Student student) {
		// Get a database connection from the connection pool
		try (Connection connection = DbConnectionPool.getDataSource().getConnection()) {
			String sql = "INSERT INTO student ( student_id,student_name, student_address, dob, gender, blood_group, phone_no) VALUES ( ?,?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentName());
			statement.setString(3, student.getStudentAddress());
			statement.setObject(4, student.getDob());
			statement.setString(5, student.getGender());
			statement.setString(6, student.getBloodGroup());
			statement.setLong(7, student.getPhoneNo());

			// Execute the SQL INSERT statement
			statement.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions that might occur during database insertion
			System.out.println("An error occurred while adding the student: " + e.getMessage());
		}
	}

	@Override
	public void updateStudent(String studentid, String column) {

		// Get a database connection from the connection pool
		try {
			Scanner scanner = new Scanner(System.in);
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String tableName = "student";

			System.out.println("updated data is-:");
			String data = scanner.nextLine();

			String condition = "student_id = ?";
			String updatequery = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + condition;

			PreparedStatement statement = connection.prepareStatement(updatequery);
			statement.setString(1, data);
			statement.setString(2, studentid);

			statement.executeUpdate();

		} catch (Exception e) {
			// Handle any exceptions that might occur during database insertion
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Student getStudent(String studentId) {
		Student student = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try (Connection connection = DbConnectionPool.getDataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM student WHERE student_id = ?")) {

			preparedStatement.setString(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Create a Student object and set its attributes from the result set
				student = new Student();
				student.setStudentId(resultSet.getString("student_id"));
				student.setStudentName(resultSet.getString("student_name"));
				student.setStudentAddress(resultSet.getString("student_address"));

				// Parse the date string to LocalDate using the formatter
				LocalDate dob = LocalDate.parse(resultSet.getString("dob"), formatter);
				student.setDob(dob);
				student.setGender(resultSet.getString("gender"));
				student.setBloodGroup(resultSet.getString("blood_group"));
				student.setPhoneNo(resultSet.getLong("phone_No"));
			}

		} catch (SQLException e) {
			// Handle the exception or log the error
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public List<Student> viewAllStudent() {
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Student> studentList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DbConnectionPool.getDataSource();
			connection = ds.getConnection();
			String query="select *from student";
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
				
				Student stud =new Student(id,name,address,dob,gender,bg,phoneNo);
				
				studentList.add(stud);
				
				
			}
			

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		return studentList;
	}
			
		
		
}	
	

