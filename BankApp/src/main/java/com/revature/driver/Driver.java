package com.revature.driver;

import com.revature.customer.Customer;
import com.revature.menu.Menu;
import com.revature.util.Bank;
import com.revature.util.IOFile;

public class Driver {
	static {
		IOFile.readCustomerFile();//before we do any operation, run this
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Customer customer = new Customer("Busayomi", "Ola", "OBUS", "Ybus", "Glen Street", "5555BL");
		
		//System.out.println(Details.customerList.toString());
		
	Menu.startMenu();
	}

}
