package com.marlabs.session.examples;

import java.util.Scanner;

public class TestClass {

	private static void getUserMenu() {
		System.out.println("*********************************");
		System.out.println("Save) Save module ");
		System.out.println("Load) Load module ");
		System.out.println("Remove) Remove module ");
		System.out.println("Update) Update module ");
		System.out.println("*********************************");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User Choice");
		String userChoice = scanner.next();
		ICustomer iCustomer = new CustomerImpl();
		switch (userChoice) {
		case "Save":
			Customer customer = new Customer();
			customer.setCustomerId(102);
			customer.setCustomerCity("Mysore");
			customer.setCustomerName("Srinivas Training Solution");
			iCustomer.saveCustomer(customer);
			break;
		case "Load":
			System.out.println("Enter customer id");
			int customerId = scanner.nextInt();
			iCustomer.getCustomer(customerId);
			break;
		case "Remove":
			System.out.println("Enter Customer Id you want to remove : ");
			int customer4 = scanner.nextInt();
			Customer customer2 = new Customer();
//			customer2.setCustomerId(101);
			customer2.setCustomerId(customer4);
			iCustomer.removeCustomer(customer2);
			break;
		case "Update":
			Customer customer1 = new Customer();
			customer1.setCustomerId(101);
			customer1.setCustomerCity("Mysore");
			customer1.setCustomerName("Vasu horizon software solution");
			iCustomer.updateCustomer(customer1);
			break;

		default:
			System.out.println("Enter correct choice");
			System.exit(0);
			break;
		}
		scanner.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("I am from main method");
		getUserMenu();
		System.out.println("End of main method");
	}

}
