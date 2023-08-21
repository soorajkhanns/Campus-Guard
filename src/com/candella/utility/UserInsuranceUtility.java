package com.candella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Insurance;
import com.candella.entity.UserInsurance;
import com.candella.entity.UserRole;
import com.candella.service.InsuranceService;
import com.candella.service.InsuranceServiceImpl;
import com.candella.service.UserInsuranceService;
import com.candella.service.UserInsuranceServiceImpl;
import com.candella.service.UserRoleService;
import com.candella.service.UserRoleServiceImpl;

public class UserInsuranceUtility {
    static Scanner scanner = new Scanner(System.in);
    static UserInsuranceService userInsuranceService = new UserInsuranceServiceImpl();
    static UserRoleService userRoleService = new UserRoleServiceImpl();
    static InsuranceService  insuranceService = new InsuranceServiceImpl();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add User Insurance");
            System.out.println("2. View User Insurance by Enrollment ID");
            System.out.println("3. View All User Insurances");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    addUserInsurance();
                    break;
                case 2:
                    viewUserInsuranceById();
                    break;
                case 3:
                    viewAllUserInsurance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    public static void addUserInsurance() {
        System.out.println("User Role ID    User Type");
        System.out.println("--------------------------------------");
        System.out.println("UR001           student");
        System.out.println("UR002           staff");
        System.out.println("--------------------------------------");
        System.out.print("Enter the User Role ID: ");
        String userRoleId = scanner.nextLine();

        UserRole userRole = userRoleService.getUserRoleById(userRoleId);
        if (userRole == null) {
            System.out.println("User Role ID not found. Please enter a valid User Role ID.");
            return;
        }

        System.out.println("Enter Enrollment ID:");
        String enrollmentId = scanner.nextLine();
        if(userRoleId=="ur002") {
        	StaffUtility.viewAllStaff();
        	
        } else {
        	
        	StudentUtility.viewAllStudent();

        	
        }
        
       

        System.out.println("Enter User ID:");
        String userId = scanner.nextLine();
        
        InsuranceUtility.viewAllInsurances();

        System.out.println("Enter Plan ID:");
        String planId = scanner.nextLine();

        System.out.println("Enter Enrollment Date (yyyy-MM-dd):");
        LocalDate enrollmentDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter Expiry Date (yyyy-MM-dd):");
        LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

     
       
        System.out.println("Entered Plan ID: " + planId);

        Insurance insurance = insuranceService.getInsurance(planId);
        if (insurance == null) {
            System.out.println("Plan ID not found");
            return;
        }

        UserInsurance userInsurance = new UserInsurance(enrollmentId, userId, insurance, userRole, enrollmentDate, expiryDate);
        userInsuranceService.addUserInsurance(userInsurance);
        System.out.println("User Insurance added successfully!");
    }

    public static void viewUserInsuranceById() {
        System.out.println("Enter Enrollment ID:");
        String enrollmentId = scanner.nextLine();

        UserInsurance userInsurance = userInsuranceService.getUserInsuranceById(enrollmentId);
        if (userInsurance != null) {
            System.out.println("User Insurance Details:");
            System.out.println(userInsurance);
        } else {
            System.out.println("User Insurance not found for Enrollment ID: " + enrollmentId);
        }
    }

    public static void viewAllUserInsurance() {
        List<UserInsurance> userInsurances = userInsuranceService.viewAllUserInsurance();
        if (userInsurances.isEmpty()) {
            System.out.println("No user insurances found.");
        } else {
            System.out.println("List of all user insurances:");
            for (UserInsurance userInsurance : userInsurances) {
                System.out.println(userInsurance);
            }
        }
    }
}
