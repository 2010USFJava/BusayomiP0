package com.revature.customer;


public class Admin {

	public static void adminPage() {
		System.out.println("***********************************");
		System.out.println("|                               |");
		System.out.println("|    Welcome Admin!    |");
		System.out.println("|                                  |");
		System.out.println("********************************");

		System.out.println("Please enter your choice:");
		System.out.println("\t[c]reate a new Account");
		System.out.println("\t[l]ogin to Your Account!");
		System.out.println("\t[m]ake deposite");
		System.out.println("\t[w]ithdrawal");
		System.out.println("\t[a]dmin Login");
		System.out.println("\t[b]alance");
		System.out.println("\t[e]mployee Login");
		System.out.println("\t[o]Log Out");
		
	}

public static void approveAndDeny() {
/**	boolean valid=false;
	double initialDeposit=0;
	String accountType="";
	while(!valid) {
			System.out.println("please enter initial value");
			try {
			 initialDeposit = Double.parseDouble(scan.nextLine());
			 }
	 catch(NumberFormatException e) {
		 System.out.println("please Deposit must be a number");
	}
		if(accountType.equalsIgnoreCase("Checkings Account")) {
			if(initialDeposit < 25) {
				System.out.println("Checkings Account requires a minimum of $25 dollars to open");
			}else {
				valid =true;
			}
		}else if(accountType.equalsIgnoreCase("Savings Account")) {
				if(initialDeposit < 50) {
					System.out.println("Savings Account requires a minimum of $50 dollars to open");
				}else {
					valid =true;
		}
		}else if(accountType.equalsIgnoreCase("Joint Account")) {
					if(initialDeposit < 100) {
						System.out.println("Joint Account requires a minimum of $50 dollars to open");
					}else {
						valid =true;
			}
	 }

}*/}}