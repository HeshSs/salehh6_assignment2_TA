import java.util.ArrayList;
import java.util.Scanner;

public class Registrar {
    ArrayList<Student> students;
    ArrayList<Course> courses;

    public Registrar() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
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
                // Course command
                case "COURSE":
                    // add the course to the list of courses
                    courses.add(new Course(inputList[1]));
                    break;

                // Student command
                case "STUDENT":
                    // add the student to the list of students
                    students.add(new Student(inputList[1], Integer.parseInt(inputList[2])));
                    break;

                // Section command
                case "SECTION":
                    // add the section to the course sections
                    for (Course course : courses) {
                        if (course.getUniqueName().equals(inputList[1])) {
                            course.addSection(new Section(inputList[2], Integer.parseInt(inputList[3])));
                        }
                    }
                    break;

                // Enroll command
                case "ENROLL":

                    break;

                // UnEnroll command
                case "UNENROLL":

                    break;

                // Requirement command
                case "REQUIREMENT":

                    break;

            }
            // set the nextLine as the new command
            inputList = sc.nextLine().split(" ");

        } while (!inputList[0].equals("FINISH")); // While the input is not finished, keep reading commands

    }
}

