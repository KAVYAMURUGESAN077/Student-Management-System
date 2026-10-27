package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableSetup {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project1",
                    "root",
                    "kavya2004"
            );

            System.out.println("Connection established");

            Statement stmt = con.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS student ("
                    + "sid INT PRIMARY KEY, "
                    + "sname VARCHAR(100), "
                    + "sph BIGINT"
                    + ")";

            stmt.executeUpdate(query);

            System.out.println("Student table created successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}