import java.util.ArrayList;

public class Section {
    private String sectionName;
    private int maxEnrolment;
    private ArrayList<Student> enrolledStudents;

    Section(String sectionName, int maxEnrolment) {
        enrolledStudents = new ArrayList<>();
        this.maxEnrolment = maxEnrolment;
        this.sectionName = sectionName;
    }

    boolean enrollStudent(Student student) {
        if (enrolledStudents.size() >= maxEnrolment)
            return false;
        enrolledStudents.add(student);
        return true;
    }

    public boolean unenrollStudent(Student student) {
        ArrayList<Student> newEnrolledList = new ArrayList<>();
        boolean result = false;

        for (Student s : enrolledStudents) {
            if (s.getStudentID() != student.getStudentID()) {
                newEnrolledList.add(s);
            } else {
                result = true;
            }
        }
        enrolledStudents = newEnrolledList;

        return result;
    }

    public String getSectionName() {
        return sectionName;
    }

    /**
     * @return The list of enrolled students
     */
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
