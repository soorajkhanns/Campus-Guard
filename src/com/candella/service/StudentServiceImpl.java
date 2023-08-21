package com.candella.service;

import java.util.List;

import com.candella.dao.StudentDAO;
import com.candella.dao.StudentDAOImpl;
import com.candella.entity.Student;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    public StudentServiceImpl() {
        // Initialize the DAO implementation
        studentDAO = new StudentDAOImpl();
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }


	@Override
	public Student getStudent(String studentId) {
		 return studentDAO.getStudent(studentId);
	}

	@Override
	public void updateStudent(String studentId, String column) {
	
		studentDAO.updateStudent(studentId,column);
	}

	@Override
	public List<Student> viewAllStudent() {
		
		return studentDAO.viewAllStudent();
	}
	
	
}
