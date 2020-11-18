package com.revature.test;

import org.junit.Test;

import com.revature.beans.Account;

public class AccountTest {

	public static Account a;
	public static Account test;
	
	
	
	
	@Test
	public void testCreateAccount() {
		Account a= new Account(1,30.0,100.0,70.0,"checkings");
		System.out.println(a.toString());
		}

	
}
