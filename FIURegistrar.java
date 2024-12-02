import javax.swing.JOptionPane;

/**
 * FIURegistrar class handles student data processing for creating an array of students
 * and processing their GPA-related information.
 */
public class FIURegistrar {

    public static void main(String[] args) {
        // Ask how many students to create
        int numberOfStudents = Integer.parseInt(JOptionPane.showInputDialog("How many students would you like to create?"));

        // Create an array of students
        Student[] students = createArrayOfStudents(numberOfStudents);

        // Process the array and display results
        processArrayOfStudents(students);
    }

    /**
     * Creates an array of Student objects by collecting data from the user.
     * @param numberOfStudents Number of students to create.
     * @return Array of Student objects.
     */
    public static Student[] createArrayOfStudents(int numberOfStudents) {
        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            JOptionPane.showMessageDialog(null, "Enter details for student " + (i + 1));

            String firstName = JOptionPane.showInputDialog("First name:");
            String lastName = JOptionPane.showInputDialog("Last name:");
            String pantherId = JOptionPane.showInputDialog("Panther ID:");

            double gpa;
            do {
                gpa = Double.parseDouble(JOptionPane.showInputDialog("GPA (0.0 - 4.0):"));
                if (gpa < 0 || gpa > 4.0) {
                    JOptionPane.showMessageDialog(null, "Invalid GPA. Please enter a number between 0.0 and 4.0.");
                }
            } while (gpa < 0 || gpa > 4.0);

            students[i] = new Student(firstName, lastName, pantherId, gpa);
        }

        return students;
    }

    /**
     * Processes an array of Student objects to find highest, lowest, and average GPA.
     * Prints each student's details and students with above-average GPA.
     * @param students Array of Student objects.
     */
    public static void processArrayOfStudents(Student[] students) {
        double highestGpa = Double.MIN_VALUE;
        double lowestGpa = Double.MAX_VALUE;
        double totalGpa = 0;
        Student highestStudent = null;
        Student lowestStudent = null;

        StringBuilder studentDetails = new StringBuilder("Student Details:\n");

        for (Student student : students) {
            studentDetails.append(student).append("\n");

            if (student.getGpa() > highestGpa) {
                highestGpa = student.getGpa();
                highestStudent = student;
            }
            if (student.getGpa() < lowestGpa) {
                lowestGpa = student.getGpa();
                lowestStudent = student;
            }

            totalGpa += student.getGpa();
        }

        double averageGpa = totalGpa / students.length;

        JOptionPane.showMessageDialog(null, studentDetails.toString());
        JOptionPane.showMessageDialog(null, "Highest GPA: " + highestStudent +
                "\nLowest GPA: " + lowestStudent +
                "\nAverage GPA: " + averageGpa);

        StringBuilder aboveAverage = new StringBuilder("Students with above-average GPA:\n");
        for (Student student : students) {
            if (student.getGpa() > averageGpa) {
                aboveAverage.append(student).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, aboveAverage.toString());
    }
}