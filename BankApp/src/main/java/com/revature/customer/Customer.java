package com.revature.customer;

import java.io.Serializable;

import com.revature.util.Account;
import com.revature.util.Bank;
import com.revature.util.IOFile;
import com.revature.util.LogThis;

public class Customer implements Serializable{
			/**
	 * 
	 */
	private static final long serialVersionUID = 8585962566256332549L;
			private String firstName;
			private String lastName;
			private String address;
			private String userName;
			private String password;
			private String driverLicense;
			private String accountType;
			private int initialDeposit;
			
			public Customer() {
				super();
				Bank.customerList.add(this);
				IOFile.writeCustomerFile(Bank.customerList);
				}


			public Customer(String firstName, String lastName, String address, String userName, String password, String driverLicense, String accountType, int initialDeposit) {
				super();
				this.firstName = firstName;
				this.lastName = lastName;
				this.address = address;
				this.userName = userName;
				this.password = password;
				this.driverLicense = driverLicense;
				this.accountType=accountType;
				this.initialDeposit=initialDeposit;
				Bank.customerList.add(this);
				IOFile.writeCustomerFile(Bank.customerList);
				LogThis.LogIt("info", "A new Customer," + this.firstName + " " + this.lastName +" , has Register to Open an Account");//to make sure works with the arraylist

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


			public String getAddress() {
				return address;
			}


			public void setAddress(String address) {
				this.address = address;
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
			
			public String getAccountType() {
				return accountType;
			}


			public void setAccountType(String accountType) {
				this.accountType = accountType;
			}
			
			public int getInitialDeposit() {
				return initialDeposit;
			}


			public void setInitialDeposit(int initialDeposit) {
				this.initialDeposit = initialDeposit;
			}
			
			@Override
			public String toString() {
				return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
						+ ", userName=" + userName + ", password=" + password + ", driverLicense=" + driverLicense +
						", accountType=" + accountType +
						", initialDeposit=" + initialDeposit +  "]";
			}
}
