package com.revature.beans;


import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.impl.AccountDaoImpl;
import com.revature.dao.impl.UsersAccountDaoImpl;
import com.revature.dao.impl.UsersDaoImpl;
import com.revature.util.LogThis;



public class Account {
	
	public static Scanner scan = new Scanner(System.in);
	public static AccountDaoImpl adi= new AccountDaoImpl();
	public static UsersAccountDaoImpl uadi= new UsersAccountDaoImpl();
	public static UsersDaoImpl udi= new UsersDaoImpl();

	private int accountId;//  BANK_ACCOUNT_ID.
	private double balance;
	private double withdraw;
	private double deposit;
	private String accountType;

	public Account() {
		super();
		//LogThis.LogIt("info", "a new account," + this.accountId +", registereda");
	}





	public Account(String accountType) {
		super();
		
		this.accountType = accountType;
		LogThis.LogIt("info", "a new account," + this.accountType +", registeredb");

	}





	public Account(int accountId, double balance, double withdraw, double deposit, String accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.accountType = accountType;
		//LogThis.LogIt("info", "a new account," + this.accountId +", registeredc");
	}

			
		public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getWithdraw() {
		return withdraw;
	}


	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}


	public double getDeposit() {
		return deposit;
	}


	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
		@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", withdraw=" + withdraw + ", deposit="
				+ deposit + ", accountType=" + accountType + "]";
	}


		public void deposit(double amount){
			
			if (amount <  0) {
				System.out.println("Invalid Input");
			}else {
				balance = balance + amount;
			
				try {
				adi.deposit(amount,this);
				adi.balance(balance, this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Available balance of $" + balance);

		LogThis.LogIt("info", "A deposit was made of " + amount +" the new balance is " + balance);	
		}
}
	
		
		public void withdraw(double amount)  {
			 	
			
			if (amount <  0) {
				
				System.out.println("Invalid Input");
			}else {
			balance=balance -amount ;
			try {
				adi.withdraw(amount,this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			System.out.println("Available balance of $" + balance);
			
		LogThis.LogIt("info", "A withdraw was made of " + amount + " the new balance is " + balance);

		}
		}



}