import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Date enrollment_date;

    // Getters, setters and constructors
    public Student(String fn, String ln, String e, Date d){
        first_name = fn;
        last_name = ln;
        email = e;
        enrollment_date = d;
    }

    public Student(){
        first_name = "";
        last_name = "";
        email = "";
        enrollment_date = null;
    }

    public String getFirst_name(){return first_name;}

    public String getLast_name(){return last_name;}

    public String getEmail(){return email;}

    public Date getEnrollment_date(){return enrollment_date;}

    public void setFirst_name(String fn){first_name = fn;}

    public void setLast_name(String ln){last_name = ln;}

    public void setEmail(String e){email = e;}

    public void setEnrollment_date(Date d){enrollment_date = d;}

    @Override
    public String toString() {
        return "["+id+"] "+first_name+" "+last_name+" ("+email+") has id number "+id+" and enrolled on "+enrollment_date;
    }
}