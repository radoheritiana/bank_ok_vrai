package com.bankok.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection connection(){
        // auto close connection
    	
    	Connection connection = null;
    	
    	String url = "jdbc:postgresql://192.168.0.104:5432/bank_ok";
    	//String url = "jdbc:postgresql://127.0.0.1:5432/bank_ok";
        Properties props = new Properties();
        //props.setProperty("user", "rado");
        props.setProperty("user", "charger_clientele");
        //props.setProperty("password", "rado");
        props.setProperty("password", "charger_clientele");

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(url, props);

            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


}
