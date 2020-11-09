package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.customer.Customer;
import com.revature.menu.Menu;


public class Bank {
			
			public static List<Customer> customerList = new ArrayList<Customer>();//list of type warrior
			
			
			public static Customer findCustomerByName(String inputName) {
				
				for (int i = 0; i < customerList.size(); i++) {
					String name = customerList.get(i).getFirstName();//i is the index
					if(inputName.equals(name)) {
						return customerList.get(i);
					}
				}
				
				System.out.println("customer not found");
				Menu.startMenu();
				return null;
				
}


			public static Customer getCustomer(int account) {
				// TODO Auto-generated method stub
				return customerList.get(account);
			}
}