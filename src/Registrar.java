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


                    inputList = sc.nextLine().split(" ");
                    break;

                // Student command
                case "STUDENT":

                    inputList = sc.nextLine().split(" ");
                    break;

                // Section command
                case "SECTION":

                    inputList = sc.nextLine().split(" ");
                    break;

                // Enroll command
                case "ENROLL":

                    inputList = sc.nextLine().split(" ");
                    break;

                // UnEnroll command
                case "UNENROLL":

                    inputList = sc.nextLine().split(" ");
                    break;

                // Requirement command
                case "REQUIREMENT":

                    inputList = sc.nextLine().split(" ");
                    break;

            }


        } while (!inputList[0].equals("FINISH"));

    }
}

