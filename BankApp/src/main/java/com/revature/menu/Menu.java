package com.revature.menu;

import java.util.Scanner;

import com.revature.customer.Customer;
import com.revature.service.Find;
import com.revature.util.Account;
import com.revature.util.Bank;
import com.revature.util.Checking;
import com.revature.util.Joint;
import com.revature.util.LogThis;
import com.revature.util.Savings;

public class Menu {
	static Scanner scan = new Scanner(System.in);


	//startmenu method consist of print statment that will be given to the users of choices available for use
	public static void startMenu() {
		System.out.println("|**********************************|");
		System.out.println("|                                  |");
		System.out.println("|  Welcome to the Anny BankingApp! |");
		System.out.println("|                                  |");
		System.out.println("************************************");

		System.out.println("Please select your option:");
		System.out.println("\t[c]reate a new Account");
		System.out.println("\t[l]ogin to Your Account!");
		System.out.println("\t[a]dmin Menu");
		System.out.println("\t[e]mployee Menu");
		System.out.println("\t[o]Log Out");

		//create variable to grab the input
		String option =scan.nextLine();


		//this switch case will based on chioce the users made////can be lowercase or uppercase letter

		switch(option.toLowerCase()) {
		case "c":
			createNewAccount();
			break;
		case "l":
			loginToAccount();
			
			break;
		case "a":
			adminMenu();
			break;
		case "e":
			employeeMenu();
			break;
		case "o":
			System.out.println("You Successfully logged out, back to main menu!!!");
			startMenu();
			break;
		default:
			System.out.println("Try again");
			startMenu();//Return to startmenu if choice not match
			break;
		}

	}


	private static void createNewAccount() {
		System.out.println("Create a new Account!");

		System.out.println("Please enter your First name : ");
		String firstName=scan.nextLine();

		System.out.println("Please enter your Last name : ");
		String lastName=scan.nextLine();

		System.out.println("Please enter your Address : ");
		String address=scan.nextLine();

		System.out.println("Please enter your Driver License : ");
		String driverLicense=scan.nextLine();

		System.out.println("Please create your Username : ");
		String username=scan.nextLine();

		System.out.println("Please enter your Password : ");
		String password=scan.nextLine();

		boolean valid = false;
		while(!valid) {
			System.out.println("Please enter Account Type, you can enter checking Savings or Joint : ");
			String accountType = scan.nextLine();
			if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("Savings")
					||accountType.equalsIgnoreCase("Joint")) {	
				valid = true;
			}
			else {
				System.out.println("Invalid Account Selection, Pls start over again!");
				createNewAccount();
			}

			System.out.println("Please create your Initial Deposit : ");
			int initialDeposit=Integer.parseInt(scan.nextLine());


			System.out.println("Thanks for Registering");


			//to feed info in to constructor
			Customer c= new Customer(firstName, lastName, address, username, password, driverLicense, accountType, initialDeposit);
			LogThis.LogIt("info", c.getFirstName() + " " + c.getLastName()+ " was created!");// to log this
			System.out.println(Bank.customerList.toString());//if i dont want to print all the startment

			System.out.println("would you like to create another  account? (y/n)");

			//to pick there choice a created another variable for choice
			String option=scan.nextLine();

			//if statement for the option choice
			if(option.equalsIgnoreCase("y")) {
				//it will return back to create menu method
				createNewAccount();
			}else if(option.equalsIgnoreCase("n")) {
				//System.out.println("Waiting for Approval from Admin!");
				//startMenu();
				System.out.println("back to main menu!");
				startMenu();
			}else {
				//incase choice not matches y/n
				System.out.println("Pick the right option from main menu");
				startMenu();


			}
		}}
	private static void loginToAccount() {
		// TODO Auto-generated method stub

		System.out.println("Please enter your userName : ");
		String userName=scan.nextLine();

		System.out.println("Please enter your Password : ");
		String password=scan.nextLine();

		if(userName.equals(userName)&& password.equals(password))
			System.out.println("Welcome to AnnyBank");

		transactions();
	}

	public static void transactions() {
		System.out.println("Please select your option:");
		System.out.println("\t[b]alance");
		System.out.println("\t[d]eposit");
		System.out.println("\t[w]ithdraw");
		System.out.println("\t[l]og Out");

		String option = scan.nextLine();

		switch(option.toLowerCase()) {
		case "b":
			System.out.println(Account.getBalance());
			transactions();
			break;
		case "d":
			System.out.println("how much would you like to deposit");
			double amount = scan.nextDouble();
			Account.deposit(amount);
			
			System.out.println("what will you like to do next");
			option = scan.nextLine();
			transactions();
			break;
		case "w":
			System.out.println("how much would you like to withdraw");
			double amountWithdraw = scan.nextDouble();
			Account.withdraw(amountWithdraw);
			System.out.println("what will you like to do next");
			option = scan.nextLine();
			transactions();
			break;
		case "l":
			startMenu();
			break;
		default:
			//System.out.println("Invalid option");
			//transactions();
		}	
	}



	public static void employeeMenu() {

		System.out.println("To check customer application, Personal and Account info ");
		System.out.println("\t[a]pprove And deny");
		System.out.println("\t[v]eiw customer info!");

		String option = scan.nextLine();

		switch(option.toLowerCase()) {
		case "a": 
			approveAndDeny();
			break;
		case "v": 
			viewCustomerInfo();
			break;
		default:
			System.out.println("Invalid option");
			startMenu();
		}	

	}

	public static void viewCustomerInfo() {
		// TODO Auto-generated method stub
		System.out.println("Please enter customer name");
		String firstName=scan.nextLine();
		Customer c=Bank.findCustomerByName(firstName);
		Find find=new Find();
		find.viewCustomerDetails(c);

		System.out.println("Customer: " + c.getFirstName() + " " + c.getLastName()  + " "+ c.getUserName()  + " "+ c.getPassword() 
		+ " " + c.getDriverLicense() + " " + c.getAccountType() + " "+ c.getInitialDeposit() + " " + "was viewed");
		LogThis.LogIt("info", c.getFirstName() + " " + c.getLastName()+ " was viewed!");

		System.out.println("Would you like to find another customer?");

		System.out.println("\t[y]es");
		System.out.println("\t[n]o");
		System.out.println("\t[l]og Out");


		String option = scan.nextLine();
		switch(option.toLowerCase()) {
		case "y":
			viewCustomerInfo();
			break;
		case "n":
			startMenu();
			break;
		default:
			System.out.println("Invalid input. Redirecting to main menu");
			startMenu();

		}
	}


	public static void approveAndDeny() {

	}

	public static void adminMenu() {
		System.out.println("Please choose from the following options.");
		System.out.println("\t[a]pprove or Deny Account");
		System.out.println("\t[m]anage EmployeesMenu");
		System.out.println("\t[c]ustomer Info");
		System.out.println("\t[t]ransactions");
		System.out.println("\t[l]ogout");
		String option = scan.nextLine();
		
		switch(option.toLowerCase()) {
		case "a":
			approveAndDeny();
			break;
		case "m":
			employeeMenu();
			break;
		case "c":
			viewCustomerInfo();
			break;
		case "t":
			transactions();
			break;
		}}}