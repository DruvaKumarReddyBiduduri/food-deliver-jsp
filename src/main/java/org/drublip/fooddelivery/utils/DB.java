package org.drublip.fooddelivery.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	static Connection connection;
    private static final String url="jdbc:mysql://localhost:3306/restaurants";
    private static final String name="root";
    private static final String password="Your password";
	
	public static Connection connect()  {
        if(connection!=null){
            return connection;
        }
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	connection= DriverManager.getConnection(url,name,password);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
			return null;
		}
	}
}
