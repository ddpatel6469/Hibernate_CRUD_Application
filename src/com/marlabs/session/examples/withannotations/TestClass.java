package com.marlabs.session.examples.withannotations;

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
			NewCustomer customer = new NewCustomer();
			customer.setCustomerId(0);
			customer.setCustomerCity("Mysori");
			customer.setCustomerName("Srinivas Technical Solution : ");
			iCustomer.saveCustomer(customer);
			break;
		case "Load":
			System.out.println("Enter customer id you want to load : ");
			int loadCustomer = scanner.nextInt();
			iCustomer.getCustomer(loadCustomer);
			break;
		case "Remove":
			System.out.println("Enter Customer Id you want to remove : ");
			int customerremove = scanner.nextInt();
			NewCustomer customerremove2 = new NewCustomer();
//			customer2.setCustomerId(101);
			customerremove2.setCustomerId(customerremove);
			iCustomer.removeCustomer(customerremove2);
			break;
		case "Update":
			NewCustomer customerupdate = new NewCustomer();
			customerupdate.setCustomerId(101);
			customerupdate.setCustomerCity("Mysore");
			customerupdate.setCustomerName("Vasu horizon software solution");
			iCustomer.updateCustomer(customerupdate);
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
