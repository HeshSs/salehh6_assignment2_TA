import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Registrar {
    ArrayList<Student> students;
    ArrayList<Course> courses;
    HashMap<Course, ArrayList<Course>> requiredCourses;

    public Registrar() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        requiredCourses = new HashMap<>();
    }

    /**
     * Finds the Student with the given studentID
     * @param studentID
     * @return Student object
     */
    public Student getStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    /**
     * Finds the Course with the given courseName
     * @param courseName
     * @return Course object
     */
    public Course getCourse(String courseName) {
        for (Course course : courses) {
            if (course.getUniqueName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    /* Hardcoded example. Instead, you need to implement new functions that read
    the input from the terminal and print the corresponding outputs. */
    public void runExampleCommands() {
        Course course1 = new Course("CS2XYZ");
        Course course2 = new Course("CS1ABC");

        Student student1 = new Student("EMMA", 23345);
        Student student2 = new Student("DAVID", 123345);

        course1.addSection(new Section("C01", 10));
        course2.addSection(new Section("C02", 1));

        boolean enrollmentResult = course1.enrollStudent(student1, "C01");
        TerminalPrinter.printEnrollmentResult(enrollmentResult, student1.getName(),
                course1.getUniqueName(), "C01");

        enrollmentResult = course1.enrollStudent(student2, "C01");
        TerminalPrinter.printEnrollmentResult(enrollmentResult, student2.getName(),
                course1.getUniqueName(), "C01");

        enrollmentResult = course2.enrollStudent(student1, "C02");
        TerminalPrinter.printEnrollmentResult(enrollmentResult, student1.getName(),
                course2.getUniqueName(), "C02");

        enrollmentResult = course2.enrollStudent(student2, "C02");
        TerminalPrinter.printEnrollmentResult(enrollmentResult, student2.getName(),
                course2.getUniqueName(), "C02");

        enrollmentResult = course2.unenrollStudent(student1, "C02");
        TerminalPrinter.printUnenrollmentResult(enrollmentResult, student1.getName(),
                course2.getUniqueName(), "C02");

        enrollmentResult = course2.unenrollStudent(student2, "C02");
        TerminalPrinter.printUnenrollmentResult(enrollmentResult, student2.getName(),
                course2.getUniqueName(), "C02");

        enrollmentResult = course2.enrollStudent(student2, "C02");
        TerminalPrinter.printEnrollmentResult(enrollmentResult, student2.getName(),
                course2.getUniqueName(), "C02");
    }

    /**
     * The main function that reads the input, saves the data to the database and outputs the
     * result to standard output.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] inputList = sc.nextLine().split(" ");
        String command;

        do {
            command = inputList[0];

            switch(command) {
                // COURSE courseName
                case "COURSE":
                    // add the course to the list of courses
                    courses.add(new Course(inputList[1]));
                    break;

                // STUDENT studentName studentID
                case "STUDENT":
                    // add the student to the list of students
                    students.add(new Student(inputList[1], Integer.parseInt(inputList[2])));
                    break;

                // SECTION courseName section maxCapacity
                case "SECTION":
                    // add the section to the course sections
                    for (Course course : courses) {
                        if (course.getUniqueName().equals(inputList[1])) {
                            course.addSection(new Section(inputList[2], Integer.parseInt(inputList[3])));
                        }
                    }
                    break;

                // ENROLL studentID CourseName section
                case "ENROLL":
                    // find the student
                    Student student = getStudent(Integer.parseInt(inputList[1]));

                    // find the course
                    Course course = getCourse(inputList[2]);

                    // enroll the student in the appropriate section
                    boolean enrollmentResult = course.enrollStudent(student, inputList[3]);
                    TerminalPrinter.printEnrollmentResult(enrollmentResult, student.getName(),
                            course.getUniqueName(), inputList[3]);
                    break;

                // UNENROLL studentID CourseName section
                case "UNENROLL":
                    // find the student
                    Student student1 = getStudent(Integer.parseInt(inputList[1]));

                    // find the course
                    Course course1 = getCourse(inputList[2]);

                    boolean unenrollmentResult = course1.unenrollStudent(student1, inputList[3]);
                    TerminalPrinter.printUnenrollmentResult(unenrollmentResult, student1.getName(),
                            course1.getUniqueName(), inputList[3]);
                    break;

                // REQUIREMENT courseName requiredCourseName
                case "REQUIREMENT":

                    break;

            }
            // set the nextLine as the new command
            inputList = sc.nextLine().split(" ");

        } while (!inputList[0].equals("FINISH")); // While the input is not finished, keep reading commands

    }
}

