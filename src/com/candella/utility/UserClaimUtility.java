package com.candella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.UserClaims;
import com.candella.entity.UserInsurance;

import com.candella.service.UserClaimService;
import com.candella.service.UserClaimServiceImpl;
import com.candella.service.UserInsuranceService;
import com.candella.service.UserInsuranceServiceImpl;

public class UserClaimUtility {
    static Scanner scanner = new Scanner(System.in);
    static UserClaimService userClaimService = new UserClaimServiceImpl();
    static UserInsuranceService userInsuranceService  =new UserInsuranceServiceImpl();


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add User claim");
            System.out.println("2. View User claim by Claim ID");
            System.out.println("3. View All User Claims");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    addUserClaim();
                    break;
                case 2:
                    viewUserClaimById();
                    break;
                case 3:
                    viewAllUserClaims();
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

    private static void addUserClaim() {
        System.out.println("Enter Claim ID:");
        String claimId = scanner.nextLine();

        // Collect other user claim details from the user
        UserInsuranceUtility.viewAllUserInsurance();
        System.out.println("Enter Enrollment ID:");
        String enrollmentId = scanner.nextLine();

        System.out.println("Enter Claim Date (yyyy-MM-dd):");
        LocalDate claimDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter Claim Description:");
        String claimDescription = scanner.nextLine();
        
        System.out.println("Enter Claim Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left by nextDouble()

        System.out.println("Enter Bill Amount:");
        double billamount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left by nextDouble()

        System.out.println("Enter Disbursement Date (yyyy-MM-dd):");
        LocalDate disbursementDate = LocalDate.parse(scanner.nextLine());

        // Prompt for claim status
        System.out.println("Enter Claim Status:");
        String claimStatus = scanner.nextLine();

        UserInsurance userInsurance = userInsuranceService.getUserInsuranceById(enrollmentId);

        // Create a UserClaims object with the collected details
        UserClaims userClaim = new UserClaims(claimId, userInsurance, claimDate, claimDescription, amount, billamount, disbursementDate);

        // Call the addUserClaim method of UserClaimService to add the user claim
        userClaimService.addUserClaim(userClaim);

       
        System.out.println("User Claim added successfully!");
    }


    private static void viewUserClaimById() {
        System.out.println("Enter Claim ID:");
        String claimId = scanner.nextLine();

        // Call the getUserClaimsById method of UserClaimService to retrieve the user claim
        UserClaims userClaim = userClaimService.getUserClaimsById(claimId);

        if (userClaim != null) {
            System.out.println("User Claim Details:");
            System.out.println(userClaim.getUserInsurance().getEnrollmentId());
            System.out.println(userClaim.getClaimDate());
            System.out.println(userClaim.getClaimDescription());
            System.out.println(userClaim.getBillAmount());
            System.out.println(userClaim.getClaimAmount());
            System.out.println(userClaim.getDisbursementDate());
        } else {
            System.out.println("User Claim not found for Claim ID: " + claimId);
        }

    }


    private static void viewAllUserClaims() {
        List<UserClaims> userClaims = userClaimService.viewAllUserClaims();
        if (userClaims.isEmpty()) {
            System.out.println("No user claims found.");
        } else {
            System.out.println("List of all user claims:");
            for (UserClaims userClaim : userClaims) {
                System.out.println(userClaim.getUserInsurance().getEnrollmentId());
                System.out.println(userClaim.getClaimDate());
                System.out.println(userClaim.getClaimDescription());
                System.out.println(userClaim.getBillAmount());
                System.out.println(userClaim.getClaimAmount());
                System.out.println(userClaim.getDisbursementDate());
            }
          
        }}}