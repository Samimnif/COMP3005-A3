/**
 * Assignment 3 Q1
 * Sami Mnif - 101199669
 *
 * In this class, we defined 4 functions:
 * - `getAllStudents()`: Retrieves and displays all records from the students table.
 * - `addStudent(first_name, last_name, email, enrollment_date)`: Inserts a new student record into the students table.
 * - `updateStudentEmail(student_id, new_email)`: Updates the email address for a student with the specified student_id.
 * - `deleteStudent(student_id)`: Deletes the record of the student with the specified student_id.
 *
 * We are accessing the postgresql database using the driver.
 */
package org.example;

import java.sql.*;

public class Main {
    private final String url = "jdbc:postgresql://localhost:5432/Assignment3-Q1";
    private final String user = "postgres";
    private final String password = "3005";

    public static final String RED = "\033[0;31m", GREEN = "\033[0;32m", PURPLE = "\033[0;35m", RESET = "\033[0m";     // TEXT Colors

    /**
     * The constructor just checks if there is a connection to the database url provided above.
     *
     * If it fails, it will exit the program.
     */
    public Main() {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ignored) {}

        if (conn != null) {
            System.out.println(GREEN+"Connected to the database"+RESET);
        }
        else {
            System.out.println(RED+"Failed to connect"+RESET);
            System.exit(1);
        }
        System.out.println();
    }

    /**
     * Retrieves and displays all records from the students table.
     *
     * Using the statement, we select all columns from the table 'students'.
     * And then print it console
     */
    public void getAllStudents(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();

            statement.executeQuery("SELECT * FROM students");
            ResultSet rs = statement.getResultSet();

            System.out.println("Contents of the students table");
            while(rs.next()){
                System.out.printf("ID: %s Name: %s Last Name: %s Email: %s E-Date: %s", rs.getString("student_id")
                        , rs.getString("first_name")
                        , rs.getString("last_name")
                        , rs.getString("email")
                        , rs.getDate("enrollment_date"));
                System.out.println();
            }
        } catch (Exception ignored) {
        }

    }

    /**
     * Inserts a new student record into the students table.
     * We are inserting a new student to the table using the PreparedStatement, where we input values using '?'
     * This will help us avoid the SQL injection attacks.
     *
     * Student Info:
     * @param first_name
     * @param last_name
     * @param email
     * @param enrollment_date
     */
    public void addStudent(String first_name, String last_name, String email, String enrollment_date){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES(?, ?, ?, ?)";

            try (PreparedStatement psmt = conn.prepareStatement(insertSQL)){
                psmt.setString(1, first_name);
                psmt.setString(2, last_name);
                psmt.setString(3, email);
                psmt.setDate(4, Date.valueOf(enrollment_date));
                psmt.executeUpdate();
                System.out.println(GREEN+"\nNew Student added Successfully\n"+RESET);
            } catch(Exception e){
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates the email address for a student with the specified student_id.
     * We are updating a student's email in the table using the PreparedStatement, where we input values using '?'
     * This will help us avoid the SQL injection attacks.
     *
     * @param student_id
     * @param new_email
     */
    public void updateStudentEmail(int student_id, String new_email){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String updateSQL = "UPDATE students SET email=? WHERE student_id=?";

            try (PreparedStatement psmt = conn.prepareStatement(updateSQL)){
                psmt.setString(1, new_email);
                psmt.setInt(2, student_id);
                psmt.executeUpdate();
                System.out.println(GREEN+"\nStudent email Updated Successfully\n"+RESET);
            } catch(Exception e){
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes the record of the student with the specified student_id.
     * We are deleting a student (according to their student_id) to the table using
     * the PreparedStatement, where we input values using '?'
     * This will help us avoid the SQL injection attacks.
     *
     * @param student_id
     */
    public void deleteStudent(int student_id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String updateSQL = "DELETE FROM students WHERE student_id=?";

            try (PreparedStatement psmt = conn.prepareStatement(updateSQL)){
                psmt.setInt(1, student_id);
                psmt.executeUpdate();
                System.out.println(PURPLE+"\nStudent Deleted Successfully\n"+RESET);
            } catch(Exception e){
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Edit According to the function you want to invoke
     * The main obj is used to call the functions.
     *
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.getAllStudents();
        //main.addStudent("Sami", "Mnif", "sami_email@carleton.ca", "2020-05-01");
        //main.updateStudentEmail(4, "samimnif@sce.com");
        //main.deleteStudent(2);
        //main.getAllStudents();
    }
}