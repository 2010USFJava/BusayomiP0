package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import com.revature.util.LogThis;


public class Users {
	private int usersId;//USER_ID 
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String driverLicense;
	private int age;
	
	private List<Account> usersAccounts= new ArrayList<>();
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		//LogThis.LogIt("info", u.getFirstName() + " " + u.getLastName()+ "logged in!");
		LogThis.LogIt("info", "The user," + this.userName +",  has logged in");
	}

	public Users(String firstName, String lastName, String userName, String password, String driverLicense, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.driverLicense = driverLicense;
		this.age = age;
		//LogThis.LogIt("info", "a new account," + this.firstName +", registered1");
	}

	public Users(int usersId, String firstName, String lastName, String userName, String password, String driverLicense, int age) {
		super();
		this.usersId = usersId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.driverLicense = driverLicense;
		this.age = age;
		LogThis.LogIt("info", "a new account," + this.firstName +", registered2");
		
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public List<Account> getUsersAccounts() {
		return usersAccounts;
	}

	public void setUsersAccounts(List<Account> usersAccounts) {
		this.usersAccounts = usersAccounts;
	}

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", driverLicense=" + driverLicense + ", age=" + age
				 + "]";
	}

	
}