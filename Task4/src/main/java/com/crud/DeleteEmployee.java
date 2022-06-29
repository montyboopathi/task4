package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;



public class DeleteEmployee {
	static  Logger log = Logger.getLogger(DeleteEmployee.class.getName());
	public static void Delete() throws ClassNotFoundException, SQLException {
		PreparedStatement ps;
		Scanner sc = new Scanner(System.in);
		try {
			Connection c = JdbcConnection.jdbc();
			System.out.println("Enter your Details");

			System.out.println("Enter the EmpCode");
			int empCode = sc.nextInt();
			sc.nextLine();
			
			
			System.out.println("Select Employee type 1.permanentemployee 2.parttimeemployee 3.contractemployee");
			int empType = sc.nextInt();
			if (empType < 4 && empType > 0) {

				if (empType == 1) {
					ps = c.prepareStatement("DELETE  FROM employee.permanentemployee where empCode="+empCode+";");
					ps.executeUpdate();
					log.info("data deleted successfully");;
				} else if (empType == 2) {
					ps = c.prepareStatement("DELETE  FROM employee.parttimeemployee where empCode="+empCode+";");
					ps.executeUpdate();
					ps.executeUpdate();

				} else if (empType == 3) {
					ps = c.prepareStatement("DELETE  FROM employee.contractemployee where empCode="+empCode+";");
					ps.executeUpdate();
					ps.executeUpdate();

				} else {
					log.warn("enter the correct employee type"); 
					

				}
				c.close();
			}
		}

		catch (Exception e) {
		log.error(e);

		}
	}
}