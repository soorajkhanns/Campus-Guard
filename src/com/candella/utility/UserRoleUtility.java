package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.UserRole;
import com.candella.service.UserRoleService;
import com.candella.service.UserRoleServiceImpl;

public class UserRoleUtility {
	
	
    private static Scanner scanner = new Scanner(System.in);
    private static UserRoleService userRoleService = new UserRoleServiceImpl();

    public static void main(String[] args) {
    	
    	getUserRoleById();
    	//getUserRoles();
        
    }

    private static void getUserRoles() {
        List<UserRole> userRoles = userRoleService.getUserRole();
        if (userRoles == null || userRoles.isEmpty()) {
            System.out.println("No user roles found.");
        } else {
            System.out.println("List of all user roles:");
            System.out.println("--------------------------------------");
            System.out.printf("%-15s %-15s%n", "User Role ID", "User Type");
            System.out.println("--------------------------------------");
            for (UserRole userRole : userRoles) {
                System.out.printf("%-15s %-15s%n", userRole.getUserRoleId(), userRole.getUserType());
            }
            System.out.println("--------------------------------------");
        }
    }


	private static void getUserRoleById() {
		
		getUserRoles();

		System.out.println("Enter the User Role ID :");
        String userRoleId = scanner.nextLine();

        UserRole userRole = userRoleService.getUserRoleById(userRoleId);
        if (userRole != null) {
            System.out.println("User Role Details:");
            System.out.println("User Role ID: " + userRole.getUserRoleId());
            System.out.println("User Type: " + userRole.getUserType());
        } else {
            System.out.println("User role not found for ID: " + userRoleId);
        }
		
	}
}
