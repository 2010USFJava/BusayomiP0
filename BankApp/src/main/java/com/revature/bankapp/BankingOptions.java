package com.revature.bankapp;

import java.util.Scanner;

public class BankingOptions {
	
	Scanner keyboard = new Scanner(System.in);//instance variable
	Bank b = new Bank();//instance variable// bank class has list of customer which bankoption keeps track of customer that will be doing operations from
	boolean exit;//variable
	public static void main(String[] args) {
	}
	public void runBankingOption() {
		printHeader();
		while(!exit) {
			printBankingOption();
			int option =getInput();
			performAction(option);
		}
	}
	
	private int getInput() {// to get input from the keyboard and return it back to int option
		int option = -1;
		do {
			System.out.println("Enter an option: ");
		
		try {
			option =Integer.parseInt(keyboard.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Option.");
		}
		if(option < 0 || option >7 ) {
			System.out.println("Out of range");
		}
		}
		while(option < 0 || option >7 );
		
		return option;
	}
	private void printBankingOption() {
		System.out.println("Please Select an Option to Continue!");
		System.out.println("1.) Login to Your Account");
		System.out.println("2.) Create a new Account");
		System.out.println("3.) Deposit");
		System.out.println("4.) Withdrawal");
		System.out.println("5.) Check Balance");
		System.out.println("6.) Admin Login");
		System.out.println("7.) Employee Login");
		System.out.println("0.) Exit");

	}
	private  void printHeader() {
		System.out.println("*******************************************************");
		System.out.println("|                                                     |");
		System.out.println("|         Welcome to The Banking App                  |");
		System.out.println("|                                                     |");
		System.out.println("*******************************************************");

	}
	private void performAction(int option) {
		switch(option) {
		case 0:
			System.out.println("");
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		default:

		}
	}
}
