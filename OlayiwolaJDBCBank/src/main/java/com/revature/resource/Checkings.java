package com.revature.resource;

import com.revature.beans.Account;

public class Checkings extends Account{
	
	private static String accountType ="Checking";

	 public  Checkings() {
			getBalance();
			
		}

		@Override
		public String toString() {
			return "Account Type: " + accountType + "Account\n" + 
					
					"Balance: " + getBalance() + "\n" ;
					
		}
		}
