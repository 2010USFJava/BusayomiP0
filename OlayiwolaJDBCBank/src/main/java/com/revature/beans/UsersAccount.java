package com.revature.beans;


public class UsersAccount {
	private int accountId;//  BANK_ACCOUNT_ID.
	private int usersId;//USER_ID 
	
	
	public UsersAccount() {
		super();
		
	}


	public UsersAccount(int accountId, int usersId) {
		super();
		this.accountId = accountId;
		this.usersId = usersId;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	
	public int getUsersId() {
		return usersId;
	}


	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	
	@Override
	public String toString() {
		return "UsersAccount [accountId=" + accountId + ", usersId=" + usersId + "]";
	}


}
