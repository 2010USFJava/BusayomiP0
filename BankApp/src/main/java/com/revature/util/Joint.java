package com.revature.util;

public class Joint extends Account{
	public static String accountType ="Joint";

	public Joint(double initialDeposit) {//constructor
		super();
		Account.setBalance(initialDeposit);//call the parent "account" to set initial deposit
		
	}
	@Override
	public String toString() {
		return "Account Type: " + accountType + "Account\n" + 
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Balance: " + Account.getBalance() + "\n" ;
	}}