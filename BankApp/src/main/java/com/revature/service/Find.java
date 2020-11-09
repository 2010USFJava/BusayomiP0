package com.revature.service;

import com.revature.customer.Customer;
import com.revature.util.Bank;
import com.revature.util.IOFile;

public class Find {
	public void viewCustomerDetails(Customer c) {
		IOFile.writeCustomerFile(Bank.customerList);
		
	}
}
