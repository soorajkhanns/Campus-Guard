package com.candella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Staff;
import com.candella.service.StaffService;
import com.candella.service.StaffServiceImpl;

public class StaffUtility {

	
		 public static  Scanner scanner = new Scanner(System.in);
		    
		    public static  StaffService staffService = new StaffServiceImpl();

		    public static void main(String[] args) {
		        int choice ;
		        do {
		            System.out.println("1.Add Staff     2.Update Staff     3.ViewAll    4.Exit");
		            choice = scanner.nextInt();
		            scanner.nextLine(); // Consume the newline character left by nextInt()

		            switch (choice) {
		                case 1:
		                    addStaff();
		                    break;
		                case 2:
		                	updateStaff();
		                	break;
		                case 3:
		                    viewAllStaff();
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

		    public static void addStaff() {
		        System.out.println("Enter staff ID:");
		        String staffId = scanner.nextLine();

		        System.out.println("Enter staff name:");
		        String staffName = scanner.nextLine();

		        System.out.println("Enter staff address:");
		        String staffAddress = scanner.nextLine();

		        System.out.println("Enter staff date of birth (yyyy-MM-dd):");
		        LocalDate dob = LocalDate.parse(scanner.nextLine());

		        System.out.println("Enter staff gender:");
		        String gender = scanner.nextLine();

		        System.out.println("Enter staff blood group:");
		        String bloodGroup = scanner.nextLine();

		        System.out.println("Enter staff phone number:");
		        long phoneNo = Long.parseLong(scanner.nextLine());

		        Staff newStaff = new Staff(staffId, staffName, staffAddress, dob, gender, bloodGroup, phoneNo);
		        staffService.addStaff(newStaff);
		        System.out.println("Staff added successfully.");
		    }

		    public static void updateStaff() {
		        System.out.println("Enter staff ID to update:");
		        String staffId = scanner.nextLine();
		        System.out.println("Enter the column to update:");
		        String column = scanner.nextLine();

		        staffService.updateStaff(staffId, column);
		        System.out.println("///Updated Successfully///");
		    }

		    public static void viewAllStaff() {
		        List<Staff> staffList = staffService.viewAllStaff();
		        if (staffList.isEmpty()) {
		            System.out.println("No staff found.");
		        } else {
		            System.out.println("List of all staff:");
		            for (Staff staff : staffList) {
		                System.out.println(staff);
		            }
		        }
		    }

		    
	

	}

