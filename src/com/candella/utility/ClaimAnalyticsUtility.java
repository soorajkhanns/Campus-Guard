package com.candella.utility;

import java.time.LocalDate;
import java.util.Scanner;

import com.candella.dao.ClaimAnalyticsDAO;
import com.candella.dao.ClaimAnalyticsDAOImpl;
import com.candella.entity.ClaimAnalytics;
import com.candella.entity.UserClaims;
import com.candella.entity.UserInsurance;
import com.candella.service.ClaimAnalyticsService;
import com.candella.service.ClaimAnalyticsServiceImpl;
import com.candella.service.UserClaimService;
import com.candella.service.UserClaimServiceImpl;
import com.candella.service.UserInsuranceServiceImpl;

public class ClaimAnalyticsUtility {
	 ClaimAnalyticsDAO claimAnalyticsDAO = new ClaimAnalyticsDAOImpl();
	 static ClaimAnalyticsService claimAnalyticsService = new ClaimAnalyticsServiceImpl();
    static Scanner scanner = new Scanner(System.in);
  
    static UserClaimService userClaimService = new UserClaimServiceImpl();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. View Claim Analytics by Claim ID");
            System.out.println("2. View Trial");
            System.out.println("3. View Average Percentage of a plan");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    viewClaimAnalyticsByClaimId();
                    break;
                case 2:
                	viewAllClaimAnalytics();
                	break;
                case 3:
                	calculateAverageClaimPercentageForPlan();
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

  

	private static void viewClaimAnalyticsByClaimId() {
        System.out.println("Enter Claim ID:");
        String claimId = scanner.nextLine();

        // Fetch the UserClaims object based on the claimId
        UserClaims userClaim = userClaimService.getUserClaimsById(claimId);

        if (userClaim != null) {
            // Call the getClaimAnalyticsById method of ClaimAnalyticsService to retrieve the claim analytics
            ClaimAnalytics claimAnalytics = claimAnalyticsService.getClaimAnalyticsById(userClaim);

            if (claimAnalytics != null) {
                System.out.println("Claim Analytics Details:");
                System.out.println("Claim ID: " + userClaim.getClaimId());
                System.out.println("Claim Type: " + claimAnalytics.getClaimType());
                System.out.println("Claim Status: " + claimAnalytics.getClaimStatus());
                System.out.println("Claim Percentage: " + claimAnalytics.getClaimPercentage() + "%");
            } else {
                System.out.println("Claim Analytics not found for Claim ID: " + claimId);
            }
        } else {
            System.out.println("User Claims not found for Claim ID: " + claimId);
        }
    
    }
    private static void viewAllClaimAnalytics() {
    	UserInsuranceServiceImpl userInsuranceService= new UserInsuranceServiceImpl();
    	System.out.println("Enter Claim ID:");
        String claimId = scanner.nextLine();

        // Collect other user claim details from the user
        UserInsuranceUtility.viewAllUserInsurance();
        System.out.println("Enter Enrollment ID:");
        String enrollmentId = scanner.nextLine();

        System.out.println("Enter Claim Date (yyyy-MM-dd):");
        LocalDate claimDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter Claim Type:");
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
        
        System.out.println(userClaim.getClaimId());
        System.out.println(userClaim.getUserInsurance().getEnrollmentId());
        System.out.println(userClaim.getClaimDate());
        System.out.println(userClaim.getClaimDescription());
        System.out.println(userClaim.getClaimAmount());
        System.out.println(userClaim.getBillAmount());
        System.out.println(userClaim.getDisbursementDate());
    	int percentage = 0;
		if(userClaim.getClaimAmount()<=userClaim.getBillAmount())
		{
		percentage=(int) ((userClaim.getClaimAmount()/userClaim.getBillAmount())*100);
		}
		else
		{
			percentage=100;
		}
		System.out.println("Claim percentage is" +" "+ percentage);
        

    } 
	public static void calculateAverageClaimPercentageForPlan() {
		 System.out.println("Enter Plan ID:");
	        String planId = scanner.nextLine();

	        double averageClaimPercentage = claimAnalyticsService.calculateAverageClaimPercentageForPlan(planId);

	        if (averageClaimPercentage > 0) {
	            System.out.println("Average Claim Percentage for Plan ID " + planId + ": " + averageClaimPercentage + "%");
	        } else {
	            System.out.println("No data found for Plan ID: " + planId);
	        }
	    }
	}
	