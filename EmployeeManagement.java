 package com.gds.ey.employee.serial;

import java.io.IOException;

public class EmployeeManagement {

	 public static void main(String[] args) {
		
		 try {
			new EmployeeView();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 