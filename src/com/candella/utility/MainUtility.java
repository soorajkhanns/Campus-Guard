package com.candella.utility;
	import java.util.Scanner;

		public class MainUtility {
		    public static Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        int choice;
		        do {
		            System.out.println("Menu:");
		            System.out.println("1. Student Utility");
		            System.out.println("2. Staff Utility");
		            System.out.println("3. User Claim Utility");
		            System.out.println("4. User Insurance Utility");
		            System.out.println("5. User Payment Utility");
		            System.out.println("6. User Role Utility");
		            System.out.println("7. Claim analytics Utility");
		            System.out.println("8. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();
		            scanner.nextLine(); // Consume the newline character left by nextInt()

		            switch (choice) {
		                case 1:
		                    StudentUtility.main(args);
		                    break;
		                case 2:
		                    StaffUtility.main(args);
		                    break;
		                case 3:
		                    UserClaimUtility.main(args);
		                    break;
		                case 4:
		                    UserInsuranceUtility.main(args);
		                    break;
		                case 5:
		                    UserPaymentUtility.main(args);
		                    break;
		                case 6:
		                	UserRoleUtility.main(args);
		                	break;
		                case 7:
		                    ClaimAnalyticsUtility.main(args);
		                    break;
		                case 8:
		                    System.out.println("Goodbye!");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        } while (choice != 7);
	

	}

}
