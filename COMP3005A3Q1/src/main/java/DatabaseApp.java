import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class DatabaseApp {
    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        System.out.println("APPLICATION START");

        deleteStudent(4);

        getAllStudents();

        System.out.println("APPLICATION END");

        factory.close();
    }

    //prints out every student in the table
    public static void getAllStudents(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        //retrieve the id of every record in the table
        ArrayList<Integer> ids = new ArrayList<Integer>(session.createQuery("SELECT s.id FROM Student s").list());
        //iterate over all students
        for(Integer i: ids){
            Student curStudent = session.get(Student.class, i);
            System.out.println(curStudent);
        }
        session.getTransaction().commit();
    }

    //add a student to the table
    public static void addStudent(String fn, String ln, String e, Date ed){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student newStudent = new Student(fn,ln, e, ed);
        session.save(newStudent);
        session.getTransaction().commit();
        System.out.println("Student "+fn+" "+ln+" added successfully!");
    }

    //update the email of a student
    public static void updateStudentEmail(int id, String e){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student existingStudent = session.get(Student.class, id);
        existingStudent.setEmail(e);
        session.getTransaction().commit();
        System.out.println("Student "+id+" email updated!");
    }

    //delete a student
    public static void deleteStudent(int id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student existingStudent = session.get(Student.class, id);  // Assuming id = 1 for simplicity
        session.delete(existingStudent);
        session.getTransaction().commit();
        System.out.println("Student "+id+" deleted!");
    }

    //helper function to convert to appropriate date type
    public static Date asDate(String date) {
        LocalDate l = LocalDate.parse(date);
        return new Date(Date.from(l.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()).getTime());
    }


}