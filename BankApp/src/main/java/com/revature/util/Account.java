package com.revature.util;

import java.util.Random;
import java.util.Scanner;

import com.revature.menu.Menu;

public class Account {
	
	static Scanner scan = new Scanner(System.in);
	
	int amount;
	
	private static double balance;
	private static double withdraw;
	private static double deposit;
	private static long accountNumber;
	
	public Account() {
	}
	public Account(long accountNumber, double balance) {
		Account.accountNumber=accountNumber;
		Account.setBalance(balance);
	}
	public static void createAccountNumber() {
		Random random = new Random();
		accountNumber=random.nextInt(1000);
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		Account.accountNumber = accountNumber;
	}
	public static double getBalance() {
		return balance;
	}
	public static void setBalance(double balance) {
		Account.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
	
	
	public static void deposit(double amount) {
		
		
		if (amount <  0) {
			System.out.println("Invalid Input");
			
			
		}
		balance = balance + amount;
		System.out.println("Available balance of $" + balance);

		LogThis.LogIt("info", "A withdraw was made of " + amount +" the new balance is " + balance);
		
		
		
	}

public static void withdraw(double amount) {
		
		
		if (amount <  0) {
			System.out.println("Invalid Input");
			
			
		}
		balance = balance -amount;
		System.out.println("Available balance of $" + balance);

		LogThis.LogIt("info", "A withdraw was made of " + amount + " the new balance is " + balance);
		
	}

public static void transfer(double amount) {
	
}

	
}