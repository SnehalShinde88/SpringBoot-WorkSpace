package com.euro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String args[]) throws Exception {
		try {
			Connection con = getConnect();
			System.out.println("connection done..." + con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		Connection con = null; // bcz of the localvariable
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/eurodata";
			con = DriverManager.getConnection(url, "root", "Asdfghjkl@1");
			System.out.println("communication established...." + con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
}
