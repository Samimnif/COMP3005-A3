package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/University";
        String user = "postgres";
        String password = "3005";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();

            //statement.execute

            if (conn != null) {
                System.out.println("Connected to the database");
            }
            else System.out.println("Failed to connect");


        } catch (Exception ignored) {
        }


    }
}