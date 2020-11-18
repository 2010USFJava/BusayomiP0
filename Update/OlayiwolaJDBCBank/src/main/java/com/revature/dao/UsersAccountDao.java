package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Account;
import com.revature.beans.Users;

public interface UsersAccountDao {
	
	public Users findUsersbyName(String firstName) throws SQLException;
	public Account findAccountById(int accountId) throws SQLException;
	
	
}
