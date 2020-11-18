package com.revature.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.revature.beans.Users;
import com.revature.dao.UsersDao;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class UsersDaoImpl implements UsersDao {
	
	public static Scanner scan = new Scanner(System.in);
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createNewUsers(Users u) throws SQLException {//register method
		Connection conn= cf.getConnection();
		
		String sql ="insert into Users (firstName,lastName,userName,password,driverLicense,age)values(?,?,?,?,?,?)";
				
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setInt(1,u.getUsersId());
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(3, u.getUserName());
		ps.setString(4, u.getPassword());
		ps.setString(5, u.getDriverLicense());
		ps.setInt(6,u.getAge());
		ps.executeUpdate();
		
	//	LogThis.LogIt("info", u.getFirstName() + " " + u.getLastName()+ " was created in the database!");
			
}
	
	@Override
	public List<Users> viewAllUsers() throws SQLException {//VIEW METHOD
		List<Users> usersList = new ArrayList<Users>();
		Connection conn = cf.getConnection();//
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from users");
		Users u = null;
		while(rs.next()) {
			
			u= new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getInt(7));//column is the field
			
			usersList.add(u);
			
			LogThis.LogIt("info", "All users ,"+ " "+ viewAllUsers()+ " were viewed!");

		}
		return usersList;
	}
	
	
	
	public void viewAllUsers(Users u)throws SQLException {
		viewAllUsers(u);
		
	}

	public void updateName(String newFistName, int usersId) throws SQLException {//UPDATE METHOD
       
		Connection conn = cf.getConnection();
        String updateQuery = "update Users set firstName = ? where usersId = ?";
        PreparedStatement prepStmt = conn.prepareStatement(updateQuery);
       prepStmt.setString(1, newFistName);
        prepStmt.setInt(2, usersId);
        prepStmt.executeUpdate();
        	
      LogThis.LogIt("info", newFistName + " " + usersId + " was updated!");
    }
	
	
	
	
	
	public void deleteUsers(int usersId, double balance) throws SQLException {//DELETE IF ACT EMPTY
		Connection conn = cf.getConnection();
		String deleteQuery = "delete from users where usersId=? ";
        PreparedStatement prepStmt = conn.prepareStatement(deleteQuery);
       
        prepStmt.setInt(1, usersId);
        prepStmt.setDouble(2, balance);
        prepStmt.executeUpdate();
        
        LogThis.LogIt("info", usersId + " " + balance + " was deleted!");		
	}
	
	
	public void logIn() throws SQLException{// login method

		System.out.println("Please enter your userName : ");
		String userName=scan.nextLine();

		System.out.println("Please enter your Password : ");
		String password=scan.nextLine();
		
		Connection conn = cf.getConnection();
		
        String selectQuery = ("select password from Users where userName =?");
        PreparedStatement prepStmt = conn.prepareStatement(selectQuery);
      
        prepStmt.setString(1, userName);
       // prepStmt.setString(2, password);
        
        ResultSet rs =prepStmt.executeQuery();
      while(rs.next()) {
    	  String  password2 =rs.getString(1);
    	  
    	  if(password2.equals(password)) {
  			System.out.println("Welcome to AnnyBankingApp");
  		}
 }
       // userName =rs.getString(4);
                 
		
		
		

	
	}


}


	

