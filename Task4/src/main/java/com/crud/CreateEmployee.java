package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CreateEmployee {
	private static final Logger log = LogManager.getLogger(CreateEmployee.class);
	//static  Logger log = Logger.getLogger(CreateEmployee.class.getName());
	public static void Create() throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps;
		Scanner sc = new Scanner(System.in);
		try {
			log.info("program Started");
			Connection c = JdbcConnection.jdbc();
			System.out.println("Enter your Details");

			System.out.println("Enter the EmpCode");
			int empCode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Your name");
			String empName = sc.nextLine();
			System.out.println("Enter Your Salary");
			int empSalary = sc.nextInt();

			System.out.println("Select Employee type 1.permanentemployee 2.parttimeemployee 3.contractemployee");
			int empType = sc.nextInt();
			if (empType < 4 && empType > 0) {

				if (empType == 1) {
					ps = c.prepareStatement("INSERT INTO  permanentemployee VALUES ('" + empCode + "','" + empName + "','"
							+ empSalary + "')");
					ps.executeUpdate();
					log.info("data inserted");
				} else if (empType == 2) {
					ps = c.prepareStatement(
							"INSERT INTO parttimeemployee VALUES ('" + empCode + "','" + empName + "','" + empSalary + "')");
					ps.executeUpdate();

				} else if (empType == 3) {
					ps = c.prepareStatement(
							"INSERT INTO contractemployee VALUES('" + empCode + "','" + empName + "','" + empSalary + "')");
					ps.executeUpdate();

				}else {
					log.warn("data not inserted");
					

				}
				
				c.close();
			}
		}
	
		catch (Exception e) {
			log.warn("connection not created");

		}
	}
}