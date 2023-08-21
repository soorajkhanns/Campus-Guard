package com.candella.utility;


		import java.util.List;
import java.util.Scanner;

import com.candella.entity.Insurance;
import com.candella.service.InsuranceService;
import com.candella.service.InsuranceServiceImpl;

		public class InsuranceUtility {

		    public static Scanner scanner = new Scanner(System.in);

		    public static InsuranceService insuranceService = new InsuranceServiceImpl();

		    public static void main(String[] args) {
		        int choice;
		        do {
		            System.out.println("1. Add Insurance     2. Update Insurance     3. View All Insurances    4. Exit");
		            choice = scanner.nextInt();
		            scanner.nextLine(); // Consume the newline character left by nextInt()

		            switch (choice) {
		                case 1:
		                    addInsurance();
		                    break;
		                case 2:
		                    updateInsurance();
		                    break;
		                case 3:
		                    viewAllInsurances();
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

		    public static void addInsurance() {
		    	 System.out.println("Enter plan ID:");
		         String planId = scanner.nextLine();

		         System.out.println("Enter plan name:");
		         String planName = scanner.nextLine();

		         System.out.println("Enter plan description:");
		         String description = scanner.nextLine();

		         System.out.println("Enter plan coverage:");
		         Long coverage = scanner.nextLong();

		         System.out.println("Enter plan amount:");
		         Long amount = scanner.nextLong();

		         System.out.println("Enter plan coverage limit:");
		         Double coverageLimit = scanner.nextDouble();

		         System.out.println("Enter plan age limit:");
		         int ageLimit = scanner.nextInt();

		         Insurance newInsurance = new Insurance(planId, planName, description, coverage, amount, coverageLimit, ageLimit);
		         InsuranceServiceImpl insursnceServiceImpl = new InsuranceServiceImpl();
		         
		         insursnceServiceImpl.addInsurance(newInsurance);
		         System.out.println("Insurance added successfully.");
		    }

		    
		    public static void updateInsurance() {
		        System.out.println("Enter the Plan ID to update:");
		        String planId = scanner.nextLine();

		        // Check if the insurance with the given planId exists
		        Insurance existingInsurance = insuranceService.getInsurance(planId);
		        if (existingInsurance == null) {
		            System.out.println("Insurance with Plan ID '" + planId + "' not found.");
		            return;
		        }

		        System.out.println("Enter the column to update (plan_name, description, coverage, amount, coverage_limit, age_limit):");
		        String columnToUpdate = scanner.nextLine();

		        System.out.println("Enter the new value:");
		        String newValue = scanner.nextLine();

		        // Update the insurance with the new value
		        insuranceService.updateInsurance(columnToUpdate, newValue);
		        System.out.println("Insurance updated successfully.");
		    }

		    public static void viewAllInsurances() {
		    	 List<Insurance> insurances = insuranceService.viewAllInsurance();
		         if (insurances.isEmpty()) {
		             System.out.println("No insurances found.");
		         } else {
		             System.out.println("List of all insurances:");
		             for (Insurance insurance : insurances) {
		                 System.out.println(insurance);
		             }
		         }
		     }
		    }
		
