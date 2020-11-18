package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Account;

public interface AccountDao {
	
	public void createAccount(Account account) throws SQLException;
	public void deposit(double amount, Account account) throws SQLException;
	public void withdraw(double amount, Account account) throws SQLException;
	public void balance(double balance, Account account) throws SQLException;
}
