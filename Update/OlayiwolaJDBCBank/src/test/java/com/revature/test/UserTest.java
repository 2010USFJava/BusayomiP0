package com.revature.test;

import org.junit.Test;

import com.revature.beans.Users;

public class UserTest {

	public static Users u;
	public static Users test;
	
	
	
	
	@Test
	public void testCreateNewUsers() {
		Users u= new Users("Busayomi", "Olayiwola","yomi", "wola", "8888b", 30);
		System.out.println(u.toString());
		}

}
