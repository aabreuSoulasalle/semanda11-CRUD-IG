package com.poo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://abnerdaniel.ckdpir6e8zbj.us-east-1.rds.amazonaws.com:3306/cloudtester"; 
	private static final String USER = "abner"; 
	private static final String SENHA = "abnerdaniel"; 
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, SENHA);
		} catch(SQLException e) {
			throw new RuntimeException("Erro na Conexão com o banco");
		}
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				//todo auto generated catch block
				e.printStackTrace();  
			}
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				//todo auto generated catch block
				e.printStackTrace();  
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				//todo auto generated catch block
				e.printStackTrace();  
			}
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				//todo auto generated catch block
				e.printStackTrace();  
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				//todo auto generated catch block
				e.printStackTrace();  
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				//todo auto generated catch block
				e.printStackTrace();  
			}
		}
	}
	
}
