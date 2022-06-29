package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;



public class JdbcConnection {

	static  Logger log = Logger.getLogger(JdbcConnection.class.getName());
	public static Connection c=null;
	public static Connection jdbc() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "123456789");
		log.info("driver is connected");
		return c;
	
	
}
}
