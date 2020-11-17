package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class AccountDaoImpl implements AccountDao{
	public static Scanner scan = new Scanner(System.in);
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	@Override
	public void createAccount(double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql ="insert into Users (balance,accountType)values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, balance);
		ps.setString(2, "Checking");
		ps.executeUpdate();
		LogThis.LogIt("info", "New Account created and added to database initial deposit: $" + balance);
	}

	@Override
	public void deposit(double amount, Account account) throws SQLException {
		Connection conn = cf.getConnection();
        String updateQuery = "update Account set balance = ? where accountId = ?";
        PreparedStatement prepStmt = conn.prepareStatement(updateQuery);
      
        prepStmt.setDouble(1, amount);
        prepStmt.setInt(2, account.getAccountId());
        prepStmt.executeUpdate();
        	
       
        
		LogThis.LogIt("info", "A deposit was made of " + amount +" the new balance is " + account);	
	}



	@Override
	public void withdraw(double amount, Account account) throws SQLException {
		Connection conn = cf.getConnection();
        String updateQuery = "update Account set balance = ? where accountId = ?";
        PreparedStatement prepStmt = conn.prepareStatement(updateQuery);
        prepStmt.setDouble(1, amount);
        prepStmt.setInt(2, account.getAccountId());
        prepStmt.executeUpdate();
		LogThis.LogIt("info", "A deposit was made of " + amount +" the new balance is " + account);	

	
		
	}
	
	
	
}
