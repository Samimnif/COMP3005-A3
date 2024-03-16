package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    private final String url = "jdbc:postgresql://localhost:5432/University";
    private final String user = "postgres";
    private final String password = "3005";
    public Main() {
    }

    public void getAllStudents(){

    }

    public void addStudent(String first_name, String last_name, String email, String enrollment_date){

    }

    public void updateStudentEmail(int student_id, String new_email){

    }

    public void deleteStudent(int student_id){

    }
    public static void main(String[] args) {


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