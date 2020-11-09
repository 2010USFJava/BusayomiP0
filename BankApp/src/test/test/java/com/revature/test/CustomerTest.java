package com.revature.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.customer.Customer;

import com.revature.util.Account;

public class CustomerTest {

	static Customer c;
	
	@BeforeClass
	public static void customerTest() {
		Customer c= new Customer("Busayomi", "Olayiwola", "999 Court Street", "yomi", "wola", "8888b", "Savings", 0);
		System.out.println(c.toString());
	}
	
	@Test
	public void depositTest() {
		double amount = 0;
		Account.deposit(amount);
		
		//assertEquals;
	}
}
