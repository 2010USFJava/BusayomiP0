package com.revature.customer;


	public class Employee {
		
		enum AccessLevel {
			customer,
			employee,
			admin
			}
		
		public String username;
		public String password;
		public String employeeNum;
		public Employee() {
			super();
			
		}

		public Employee(String username, String password, String employeeNum) {
			super();
			this.username = username;
			this.password = password;
			this.employeeNum= employeeNum;
		}


		public String getEmployeeNum() {
			return employeeNum;
		}

		public void setEmployeeNum(String employeeNum) {
			this.employeeNum = employeeNum;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Employees [username=" + username + ", password=" + password + "]";
		} 
	}

