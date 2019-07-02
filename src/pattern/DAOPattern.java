package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oalizada on 12/8/2016.
 */
public class DAOPattern {
}



class StudentDAOPattern {
    private String name;
    private int rollNo;
    StudentDAOPattern(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}


 interface StudentDao {
    public List<StudentDAOPattern> getAllStudents();
    public StudentDAOPattern getStudent(int rollNo);
    public void updateStudent(StudentDAOPattern student);
    public void deleteStudent(StudentDAOPattern student);
}

class StudentDaoImpl implements StudentDao {
    //list is working as a database
    List<StudentDAOPattern> students;
    public StudentDaoImpl(){
        students = new ArrayList<StudentDAOPattern>();
        StudentDAOPattern student1 = new StudentDAOPattern("Robert",0);
        StudentDAOPattern student2 = new StudentDAOPattern("John",1);
        students.add(student1);
        students.add(student2);
    }
    @Override
    public void deleteStudent(StudentDAOPattern student) {
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No " + student.getRollNo()
                +", deleted from database");
    }
    //retrive list of students from the database
    @Override
    public List<StudentDAOPattern> getAllStudents() {
        return students;
    }
    @Override
    public StudentDAOPattern getStudent(int rollNo) {
        return students.get(rollNo);
    }
    @Override
    public void updateStudent(StudentDAOPattern student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo()
                +", updated in the database");
    }
}


class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
//print all students
        for (StudentDAOPattern student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : "
                    +student.getRollNo()+", Name : "+student.getName()+" ]");
        }
        //update student
        StudentDAOPattern student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);
//get the student
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : "
                +student.getRollNo()+", Name : "+student.getName()+" ]");
    }
}