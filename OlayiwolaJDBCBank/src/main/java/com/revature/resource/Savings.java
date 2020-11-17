package com.revature.resource;

import com.revature.beans.Account;

public class Savings extends Account {
	public static String accountType ="Savings";

	public Savings() {//constructor
		super();
		getBalance();//call the parent "account" to set initial deposit
		
	}

	@Override
	public String toString() {
		return "Account Type: " + accountType + "Account\n" + 
				
				"Balance: " + getBalance() + "\n" ;
	}}
