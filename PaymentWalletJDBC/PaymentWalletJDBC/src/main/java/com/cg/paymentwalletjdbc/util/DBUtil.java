package com.cg.paymentwalletjdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBUtil {
	
	public static Connection getConnection() {
	Connection connection = null;
	
	OracleDriver driver = new OracleDriver();
	try {
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:oracle:thin:@10.109.2.144:1521:XE ","system","Capgemini123");
	} catch(SQLException e) {
		e.printStackTrace();
	}
return connection;
	}
}
