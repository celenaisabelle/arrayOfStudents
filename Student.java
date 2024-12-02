import javax.swing.JOptionPane;

/**
 * Student class represents a student with their details including
 * first name, last name, Panther ID, and GPA.
 */
public class Student {
    private String firstName;
    private String lastName;
    private String pantherId;
    private double gpa;

    // Constructor
    public Student(String firstName, String lastName, String pantherId, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pantherId = pantherId;
        this.gpa = gpa;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPantherId() {
        return pantherId;
    }

    public void setPantherId(String pantherId) {
        this.pantherId = pantherId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // toString Method
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                ", Panther ID: " + pantherId +
                ", GPA: " + gpa;
    }
}