package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.customer.Customer;


public class IOFile {
public static final String customerFile="customerList.txt";
	
	//write method USING
	//List of type persons
	public static void writeCustomerFile(List<Customer> cList) {
		try {
			//WE ARE ADDING OBJECT and putting a file
			//ObjectOutputStream to write object
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(customerFile));
			//writing to the list of WARRIOR element
			objectOut.writeObject(cList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}



public static void readCustomerFile() {
	try {
		ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(customerFile));
		//reading the object customer  and format it  arraylist and set it to "Details.customerList"CALLING IT FROM Details
		//save them roaster, read from list
		Bank.customerList=(ArrayList<Customer>)objectIn.readObject();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (ClassNotFoundException e){
		e.printStackTrace();
	}

}
}
