package com.candella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


import com.candella.entity.UserInsurance;
import com.candella.entity.UserPayment;
import com.candella.entity.UserRole;
import com.candella.service.UserInsuranceService;
import com.candella.service.UserInsuranceServiceImpl;
import com.candella.service.UserPaymentService;
import com.candella.service.UserPaymentServiceImpl;
import com.candella.service.UserRoleService;
import com.candella.service.UserRoleServiceImpl;

public class UserPaymentUtility {
    static Scanner scanner = new Scanner(System.in);
    static UserPaymentService userPaymentService = new UserPaymentServiceImpl();
    static UserRoleService userRoleService = new UserRoleServiceImpl();
  static UserInsuranceService userInsuranceService  =new UserInsuranceServiceImpl();


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add User Payment");
            System.out.println("2. View User Payment by Payment ID");
            System.out.println("3. View All User Payments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    addUserPayment();
                    break;
                case 2:
                    viewUserPaymentById();
                    break;
                case 3:
                    viewAllUserPayments();
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

    private static void addUserPayment() {
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

        System.out.println("Enter Payment ID:");
        String paymentId = scanner.nextLine();
        
        UserInsuranceUtility.viewAllUserInsurance();

        System.out.println("Enter Enrollment ID:");
        String enrollmentId = scanner.nextLine();

        System.out.println("Enter Payment Date (yyyy-MM-dd):");
        LocalDate paymentDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter Amount:");
        double amount = scanner.nextDouble();
       UserInsurance userInsurance = userInsuranceService.getUserInsuranceById(enrollmentId);
        
        if (userInsurance == null) {
            System.out.println("Enrollment ID not found");

        UserPayment userPayment = new UserPayment(paymentId, userInsurance,userRole, paymentDate, amount);
        userPaymentService.addUserPayment(userPayment);
        System.out.println("User Payment added successfully!");
        }
           
    }

    private static void viewUserPaymentById() {
        System.out.println("Enter Payment ID:");
        String paymentId = scanner.nextLine();

        System.out.println("Looking for Payment ID: " + paymentId); // Debugging line

        UserPayment userPayment = userPaymentService.getUserPaymentById(paymentId);
        if (userPayment != null) {
            System.out.println("User Payment Details:");
            System.out.println(userPayment);
        } else {
            System.out.println("User Payment not d for Payment ID: " + paymentId);
        }
    }

       

    private static void viewAllUserPayments() {
        List<UserPayment> userPayments = userPaymentService.viewAllUserPayments();
        if (userPayments.isEmpty()) {
            System.out.println("No user payments found.");
        } else {
            System.out.println("List of all user payments:");
            for (UserPayment userPayment : userPayments) {
                System.out.println(userPayment);
            }
        }
    }
}

