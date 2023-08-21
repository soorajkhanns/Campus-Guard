package com.candella.dao;

import java.util.List;

import com.candella.entity.Student;

public interface StudentDAO {
	
	    void addStudent(Student student);
	     Student getStudent(String studentId);
		void updateStudent(String studentId, String column);
		List<Student> viewAllStudent();
		
	}

