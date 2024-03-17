# Assignment 3 Q(1)

## Author
Sami Mnif - 101199669

## Details
### Table Creation
For this Assignment, we need to create a database and initialize it with some data.
We use postgresql to create a Database called "Assignment3-Q1".
We then use the following schema to create a table called "students"
```sql
CREATE TABLE students (
    student_id SERIAL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	enrollment_date DATE,
    Primary Key (student_id)
);
```

We then initialize the table with some data provided:

```sql 
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
```
<hr>

### Application Functions
In the `Main.java` file, we created functions that INSERT, UPDATE, and DELETE information to the 
students table.
* `getAllStudents()`: Retrieves and displays all records from the students table. 
* `addStudent(first_name, last_name, email, enrollment_date)`: Inserts a new student record into the students table. 
* `updateStudentEmail(student_id, new_email)`: Updates the email address for a student with the specified student_id. 
* `deleteStudent(student_id)`: Deletes the record of the student with the specified student_id.

<hr>

### Usage
Run the main in the `Main.java` file, edit according to your needs
```java
public static void main(String[] args) {
        Main main = new Main();
        main.getAllStudents();
        //main.addStudent("Sami", "Mnif", "sami_email@carleton.ca", "2020-05-01");
        //main.updateStudentEmail(4, "samimnif@sce.com");
        main.deleteStudent(4);
        main.getAllStudents();
    }
```

### Copyright
© Copyright 2024 - Sami Mnif - COMP 3005
