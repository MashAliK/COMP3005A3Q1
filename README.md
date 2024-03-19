# COMP3005A3Q1

Youtube Demo: https://youtu.be/XoF7UQUOoXI

The application is used by first creating a Postegres table called 'A3Q1' and then updating your username and password
for pdAdmin in COMP3005A3Q1/src/main/resources/hibernate.cfg.xml.

Then the DatabaseApp.java file can be run. There are four CRUD operations that can be performed by calling the following functions:

(1) getAllStudents() - prints every record currently in the table
(2) addStudent(firstName, lastName, email, enrollmentDate) - adds the students to the records with the attributes that were passed into the
function. Note: for the date use the asDate helper function e.g asDate("2024-01-01")
(3) updateStudentEmail(id, email) - pass in the id and the new email for the student you want to update
(4) deleteStudent(id) - pass in the id of a student you want to delete
