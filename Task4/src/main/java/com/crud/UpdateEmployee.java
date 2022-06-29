package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;



public class UpdateEmployee {
	static  Logger log = Logger.getLogger(UpdateEmployee.class.getName());
	public static void Update() throws ClassNotFoundException, SQLException {
		PreparedStatement ps;
		Scanner sc = new Scanner(System.in);
		try {
			
			Connection c = JdbcConnection.jdbc();
			System.out.println("Enter your Details");

			System.out.println("Enter the EmpCode");
			int empCode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Your name");
			String empName = sc.nextLine();
			
			System.out.println("Select Employee type 1.permanentemployee 2.parttimeemployee 3.contractemployee");
			int empType = sc.nextInt();
			if (empType < 4 && empType > 0) {

				if (empType == 1) {
					ps = c.prepareStatement("UPDATE employee.permanentemployee SET empName='"+empName+"' where empCode="+empCode+";");
					ps.executeUpdate();
					log.info("data updated");
				} else if (empType == 2) {
					ps = c.prepareStatement("UPDATE employee.parttimeemployee SET empName='"+empName+"' where empCode="+empCode+";");
					ps.executeUpdate();

				} else if (empType == 3) {
					ps = c.prepareStatement("UPDATE employee.contractemployee SET empName='"+empName+"' where empCode="+empCode+";");
					ps.executeUpdate();

				} else {
					log.warn("enter the exact employee type");
					

				}
				c.close();
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}
}


