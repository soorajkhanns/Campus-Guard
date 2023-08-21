
package com.candella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Student;
import com.candella.service.StudentService;
import com.candella.service.StudentServiceImpl;

public class StudentUtility {
	
    public static  Scanner scanner = new Scanner(System.in);
    
    public static  StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        int choice ;
        do {
            System.out.println("1.Add Student     2.Update Student     3.ViewAll    4.Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                	updateStudent();
                	break;
                case 3:
                    viewAllStudent();
                    break;
                case 4:
                    System.out.println("Exiting the utility.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    public static void addStudent() {
        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();

        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        System.out.println("Enter student address:");
        String studentAddress = scanner.nextLine();

        System.out.println("Enter student date of birth (yyyy-MM-dd):");
        LocalDate dob = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter student gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter student blood group:");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter student phone number:");
        long phoneNo = Long.parseLong(scanner.nextLine());

        Student newStudent = new Student(studentId, studentName, studentAddress, dob, gender, bloodGroup, phoneNo);
        studentService.addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    public static void updateStudent() {
    	
    	System.out.println("Enter student ID to update:");
    	String studentId = scanner.nextLine();
        System.out.println("Enter the column to update:");
        String column = scanner.nextLine();

         studentService.updateStudent(studentId,column);
       System.out.println("///Updated Successfully///");
        
    }
    public static void viewAllStudent() {
    	StudentServiceImpl studentserviceimpl =new StudentServiceImpl();
    	
    	List<Student> studentList;
    	studentList=(List<Student> )studentserviceimpl.viewAllStudent();
    	for(Student stud:studentList) {
    		System.out.println(stud.getStudentId()+" "+stud.getStudentName()+" "+stud.getStudentAddress()+" "+stud.getDob()+" "+stud.getGender()+" "+stud.getBloodGroup()+" "+stud.getPhoneNo());
     
    
    
            }       }}

        	
       
        
    
