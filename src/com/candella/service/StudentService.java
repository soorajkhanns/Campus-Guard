package com.candella.service;

import java.util.List;

import com.candella.entity.Student;

public interface StudentService {
    void addStudent(Student student);
    Student getStudent(String studentId);
	void updateStudent(String studentId, String column);
	List<Student> viewAllStudent();
	
}
