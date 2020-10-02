import java.util.ArrayList;

public class Student {
    private int studentID;
    private String name;

    Student(String name, int studentID) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
}
