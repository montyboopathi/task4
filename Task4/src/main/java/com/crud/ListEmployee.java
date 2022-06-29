package com.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class ListEmployee {
	static  Logger log = Logger.getLogger(ListEmployee.class.getName());
	public static void List() throws ClassNotFoundException, SQLException {
	
		ResultSet rs;
		Scanner sc = new Scanner(System.in);
		try {
			Connection c = JdbcConnection.jdbc();
			Statement s=c.createStatement();
			JSONArray data=new JSONArray();
			
			
			System.out.println("Select Employee type 1.permanentemployee 2.parttimeemployee 3.contractemployee");
			int empType = sc.nextInt();
			if (empType < 4 && empType > 0) {
			
				if (empType == 1) {
					
					rs=s.executeQuery("SELECT * FROM employee.permanentemployee");
					 while(rs.next()) {
						
					JSONObject  record= new JSONObject(); 
					record.put("empCode", rs.getInt("empCode"));
					record.put("empName", rs.getString("empName"));
					record.put("empSalary", rs.getDouble("empSalary")); 
					
					data.add(record);
					log.info("list of employee is display");
					} System.out.println(data);
					}



				} else if (empType == 2) {
				
					rs= s.executeQuery("SELECT * FROM employee.parttimeemployee");
					 while(rs.next()) {
						
					JSONObject  record= new JSONObject(); 
					record.put("empCode", rs.getInt("empCode"));
					record.put("empName", rs.getString("empName"));
					record.put("empSalary", rs.getDouble("empSalary")); 
					
					data.add(record);
					log.info("list of employee is display");
					} 
					 System.out.println(data);
					}


				 else if (empType == 3) {
				
					rs= s.executeQuery("SELECT * FROM employee.contractemployee");
					 while(rs.next()) {
						 
					JSONObject  record= new JSONObject(); 
					record.put("empCode", rs.getInt("empCode"));
					record.put("empName", rs.getString("empName"));
					record.put("empSalary", rs.getDouble("empSalary")); 
					
					data.add(record);
					log.info("list of employee is display");
					} System.out.println(data);



				} else {
					log.warn("Please Enter The Correct Employee type");
					

				}
				
	}
		

		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
}
