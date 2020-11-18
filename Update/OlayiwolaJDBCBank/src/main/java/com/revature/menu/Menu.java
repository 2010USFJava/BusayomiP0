package com.revature.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Users;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.dao.impl.UsersAccountDaoImpl;
import com.revature.dao.impl.UsersDaoImpl;
import com.revature.util.LogThis;



public class Menu {
	public static Scanner scan = new Scanner(System.in);
	public static AccountDaoImpl adi= new AccountDaoImpl();
	public static UsersAccountDaoImpl uadi= new UsersAccountDaoImpl();
	public static UsersDaoImpl udi= new UsersDaoImpl();
	public List<Users> usersList = new ArrayList<Users>();

	//startmenu method consist of print statment that will be given to the users of choices available for use
	public static void startMenu() {
		System.out.println("|**********************************|");
		System.out.println("|                                  |");
		System.out.println("|  Welcome to the Anny BankingApp! |");
		System.out.println("|                                  |");
		System.out.println("************************************");

		System.out.println("Please select your option:");
		System.out.println("\t[r]egister new user");
		System.out.println("\t[u]ser Login");
		System.out.println("\t[a]dmin menu");
		System.out.println("\t[l]og Out");

		//create variable to grab the input
		String option =scan.nextLine();
		Account a = new Account();

		//this switch case will based on chioce the users made////can be lowercase or uppercase letter

		switch(option.toLowerCase()) {
		case "r":
			System.out.println("please start with registration!");
			registerNewUser();
			startMenu();
			break;
		case "u":
			System.out.println("Login in with your username and password!");
			usersLogIn();
			
			transactions(a);
			
			break;
		case "a":
			System.out.println("Welcome Admin!");
			adminMenu();
			transactions(a);
			break;
		case "l":
			System.out.println("You Successfully logged out!!!");
			//startMenu();
			break;
		default:
			System.out.println("Try again");
			startMenu();//Return to startmenu if choice not match
			break;
		}

	}


	private static void registerNewUser() {
		
		//System.out.println("Please create your user's ID : ");
		//int usersId=Integer.parseInt(scan.nextLine());
		
		System.out.println("Please enter your First name : ");
		String firstName=scan.nextLine();

		System.out.println("Please enter your Last name : ");
		String lastName=scan.nextLine();

		System.out.println("Please enter your Driver License : ");
		String driverLicense=scan.nextLine();

		System.out.println("Please create your Username : ");
		String userName=scan.nextLine();

		System.out.println("Please enter your Password : ");
		String password=scan.nextLine();
		
		System.out.println("Please enter age: ");
			int age=Integer.parseInt(scan.nextLine());
			
			
			System.out.println("Thanks for Registering");


			
			Users u = new Users(firstName, lastName, driverLicense, userName, password, age);
			try {
				udi.createNewUsers(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//DB

			LogThis.LogIt("info", u.getFirstName() + " " + u.getLastName()+ " was created!");// to log this

			
			
			//registerNewAccount();
			
			System.out.println("would you like to  login? (y/n)");

			//to pick there choice a created another variable for choice
			String option=scan.nextLine();

			//if statement for the option choice
			if(option.equalsIgnoreCase("y")) {
				
				startMenu();
				}else if(option.equalsIgnoreCase("n")) {
				//System.out.println("Waiting for Approval from Admin!");
				//startMenu();
				System.out.println("back to main menu to choose best option for you!");
				startMenu();
			}else {
				//incase choice not matches y/n
				System.out.println("Pick the right option from main menu");
				startMenu();
			}	}
	
	
	public static void usersLogIn() {
		// TODO Auto-generated method stub

		System.out.println("Please enter your userName : ");
		String userName=scan.nextLine();

		System.out.println("Please enter your Password : ");
		String password=scan.nextLine();

		if(userName.equals(userName)&& password.equals(password))
			System.out.println("Welcome to AnnyBank");
}

	
	public static void transactions(Account account) {
		
		
		System.out.println("Please select your option:");
		System.out.println("\t[e]delete Users If Account Empty");
		System.out.println("\t[b]alance");
		System.out.println("\t[d]eposit");
		System.out.println("\t[w]ithdraw");
		System.out.println("\t[t]ransaction History");
		System.out.println("\t[l]og Out");

		String option = scan.nextLine();
		Account a = new Account(1,0.00,0.00,0.00,"checkings");

		
		switch(option.toLowerCase()) {
		case "e":
			System.out.println("Please enter your usersId : ");
			int usersId=scan.nextInt();
			System.out.println("delete Users If Account Empty");
			System.out.println(account.getBalance());
			double balance=account.getBalance();
			try {
				udi.deleteUsers(usersId,balance);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("account deleted because is empty");
			transactions(account);
			break;
		
		case "d":
			System.out.println("how much would you like to deposit");
			double amountd = scan.nextDouble();
			//System.out.println(account.getBalance());
			//double accountd=account.getBalance();
			a.deposit(amountd);
			System.out.println("what will you like to do next");
			option = scan.nextLine();
			account.deposit(amountd);
			transactions(account);
			break;
		case "w":
			System.out.println("how much would you like to withdraw");
			double amountw = scan.nextDouble();
			a.withdraw(amountw);
			System.out.println("what will you like to do next");
			option = scan.nextLine();
			account.withdraw(amountw);
			transactions(account);
			break;
		
		case "l":
			System.out.println("You have succesfully logged out");
			break;
		default:
			System.out.println("Invalid option");
			transactions(account);
		}	
	}



	
	@SuppressWarnings("null")
	public static void viewCustomerInfo() {
		// TODO Auto-generated method stub
	
		
		System.out.println("Please enter your users first name");
		String firstName=scan.nextLine();
		Users u = null;
		try {
			uadi.findUsersbyName(firstName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Users: " + u.getUsersId()+ " "+ u.getFirstName() + " " + u.getLastName()  + " "+ u.getUserName()  + " "+ u.getPassword() 
		+ " " + u.getDriverLicense() + " "+ u.getAge()  + " " + "was viewed");
		
		
		LogThis.LogIt("info", u.getFirstName() + " " + u.getLastName()+ " was viewed!");

		System.out.println("Would you like to find another user?");

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


	
	public static void adminMenu() {
		System.out.println("Please choose from the following options.");
		
		System.out.println("\t[v]iew Customer Info");
		System.out.println("\t[t]ransactions");
		System.out.println("\t[r]egister to create new user");
		System.out.println("\t[u]pdate");
		System.out.println("\t[d]elete");
		System.out.println("\t[l]ogout");
		
		String option = scan.nextLine();
		
		
		switch(option.toLowerCase()) {
		
		case "v":
			viewCustomerInfo();
			adminMenu();
			break;
			
		case "t":
			System.out.println("Please enter Users usersId");
			int usersId=scan.nextInt();
			try {
				transactions(uadi.findAccountById(usersId));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminMenu();
			break;
			
		case "r":
			registerNewUser();
			
			registerNewAccount();
			
			break;
			
		case "u":
			System.out.println("Please enter Users usersId");
			int usersId1=scan.nextInt();
			System.out.println("Please enter Users NEW first name");
			String newfirstName=scan.nextLine();
						try {
				udi.updateName(newfirstName,usersId1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Successfully update!!!");
			adminMenu();
			break;
		case "d":
			System.out.println("Please enter Users usersId");
			int usersId2=scan.nextInt();
			System.out.println("Please enter Users first name");
			double balance=scan.nextDouble();
			try {
				udi.deleteUsers(usersId2, balance);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Successfully deleted!!!");
			adminMenu();
			break;
		case "l":
			System.out.println("return back to main menu to logged out !!!");
			break;
		default:
			System.out.println("Try again, pick right option!");
			adminMenu();
			break;
		}}
	
	
	
	
	
	
	private static void registerNewAccount() {
		System.out.println("Creating a new account for user!");
		
		 
		/** System.out.println("Please enter account type");
		String accountType=scan.nextLine();
		
		 Account a= new Account(accountType);
*/
		Account a = new Account(1,0.00,0.00,0.00,"checkings");
			try {
				adi.createAccount(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}
	
	
	
	
	
	
	
}

