package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    static Connection con = null;

    public static Connection requestConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project1",
                    "root",
                    "kavya2004"
            );

            System.out.println("MySql connection established");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}