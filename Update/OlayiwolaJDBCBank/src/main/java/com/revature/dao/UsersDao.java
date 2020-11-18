package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Users;


public interface UsersDao {
	
	public void createNewUsers(Users u) throws SQLException;
	public List<Users> viewAllUsers() throws SQLException;
	public void viewAllUsers(Users u)throws SQLException;
	public void updateName(String newFistName, int usersId) throws SQLException;
	public void deleteUsers(int usersId, double balance) throws SQLException;
	public void logIn() throws SQLException;
	
	
}
