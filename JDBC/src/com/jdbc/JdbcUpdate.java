package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdate {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Registering jdbc driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			// Establish a connection
			// jdbc:oracle:jdbs_driver_version:port_no:edition(express),
			// username, password
			connection = DriverManager.getConnection("jdbc:oracle:thin:@INSISCILT-4086:1521:XE", "Anusha", "butterfly");

			// Write SQL query
			// Prepared Statement is used for DDL, DML
			// createStatement is used for create, drop, delete
			 
			// preparedStatement = connection.prepareStatement("UPDATE login set status='A'");
			preparedStatement = connection.prepareStatement("UPDATE login set status=?");
			
			preparedStatement.setString(1, "E");
			System.out.println("Updated"); 
			
			int rowsEffected = preparedStatement.executeUpdate();
			
			if(rowsEffected > 0) {
				System.out.println("Updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
