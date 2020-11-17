package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Users;

import com.revature.dao.UsersAccountDao;
import com.revature.util.ConnFactory;

public class UsersAccountDaoImpl implements UsersAccountDao {

	public static Scanner scan = new Scanner(System.in);
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	public Users findUsersId(int usersId) throws SQLException {
		Connection conn= cf.getConnection();
		String sql ="select usersId from users where usersId =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, usersId);
		ResultSet rs = ps.executeQuery();
		
		Users  u = null;
		
		while(rs.next()) {
			u= new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		}
		
		return u;
		
	
	
		}
	
	public Users findUsersbyName(String firstName) throws SQLException {
		Connection conn= cf.getConnection();
		String sql ="select firstName from users where firstName =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ResultSet rs = ps.executeQuery();
		
		Users  u = null;
		
		while(rs.next()) {
			u= new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		}
		
		return u;
		
	
	
		}
	
	public Account findAccountById(int accountId) throws SQLException {
		Connection conn= cf.getConnection();
		String sql ="select accountId from Account where accountId =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountId);
		ResultSet rs = ps.executeQuery();
		
		Account a = null;
		
		while(rs.next()) {
			a = new Account(rs.getInt(1),rs.getDouble(2), rs.getString(3));
		}
		
		return a;
}

	
	
}