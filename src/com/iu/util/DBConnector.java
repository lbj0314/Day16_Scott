package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnector {
	//
	public static Connection getConnect () throws Exception{
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.114.3:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = DriverManager.getConnection(url, user, password);

		Class.forName(driver);

		con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
