
/*
30. Develop a program that manages records for both graduate and undergraduate students? Each student should have
records for 2 labs, a midterm, and a final exam. The program should contain a method that calculates the final grade
 for every student based on the following weights: lab marks average (20%), midterm (30%), and final exam (50%).
  Additionally, incorporate a static method to determine and display the count of graduate and
  undergraduate students. Note: There's no requirement for persistent data storage.
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String firstName;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String lastName;

    private String username;
    private double lab1; // private variable (encapsulation) for lab1
    private double lab2; // lab2 for the class Student
    private double midterm; // midterm variable

    private double finalExam; // final exam variable
    private static int underGradCount = 0; // underGrad variable counter
    private static int gradCount = 0; // grad variable counter
    //boolean grad = false; // boolean is set to false by default, true if a grad

    private String gradType;

    Student () {
        underGradCount++; //increasing the count of undergrads every time a new object is made
        this.lab1 = 0; // setting lab1 to zero
        this.lab2 = 0; // setting lab2 to zero
        this.midterm = 0; // setting midterm to zero
        this.finalExam = 0; // setting final exam to zero
    }

    Student (String gradType) {
        if (gradType.equals("grad")) {
            gradCount++; //increasing the count of grads every time a new object is made
        }
        else {
            underGradCount++; //increasing the count of undergrads every time a new object is made
        }

        this.lab1 = 0; // setting lab1 to zero
        this.lab2 = 0; // setting lab2 to zero
        this.midterm = 0; // setting midterm to zero
        this.finalExam = 0; // setting final exam to zero
    }

    Student (String lastName, String firstName, String username, String grad) {
        if (grad.equals("grad")) gradCount++; //increasing the count of grads every time a new object is made
        else underGradCount++; //increasing the count of undergrads every time a new object is made

        this.lab1 = 0; // setting lab1 to zero
        this.lab2 = 0; // setting lab2 to zero
        this.midterm = 0; // setting midterm to zero
        this.finalExam = 0; // setting final exam to zero
    }

    // the following are the getter and setter values for the object Student
    // getter method for lab 1
    public double getLab1() {
        return lab1; // getter method for lab 1
    }

    // setter method for lab 1
    public void setLab1(double lab1) {
        this.lab1 = lab1; // setting the value for lab 1
    }

    // getter method for lab 2
    public double getLab2() {
        return lab2; // getter method for lab 2
    }

    // setter method for lab 2
    public void setLab2(double lab2) {
        this.lab2 = lab2; // setting the value for lab 2
    }

    // getter method for midterm
    public double getMidterm() {
        return midterm; // getter method for midterm
    }

    // setter method for midterm
    public void setMidterm(double midterm) {
        this.midterm = midterm; //setting the value for the midterm
    }

    // getter method for final exam
    public double getFinalExam() {
        return finalExam; // getter method for final exam
    }

    // setter method for final exam
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam; // setting the value for the exam
    }

    // Method to display the number of graduate and undergraduate students
    public static void studentCount() {
        System.out.println("The number of undergraduate students is " + underGradCount + " and the number of " +
                "graduate students is: " + gradCount);
}

// method to calculate the final grade for each student
    public double calcFinalGrade(Student stu, int lab1, int lab2, int midterm, int finalExam) {
        double finalGrade = 0; // initializing the finalgrade as a double value

        // calculating the final grade with the weights
        // lab marks average (20%), midterm (30%), and final exam (50%)
        finalGrade =  (lab1 * 0.10) + (lab2 * 0.10) + (midterm * 0.30) + (finalExam * 0.50);

        return finalGrade; // returning back to main with the final grade
}

public  String toString() { //overriding the toString method

        return "\n" + lastName + ", " + firstName + ", " + username + "," + gradType + "\r\n"
                + "\r\n Lab 1: " + getLab1()
                + "\r\n Lab 2: " + getLab2()
                + "\r\n Midterm: " + getMidterm()
                + "\r\n Final Exam:" + getFinalExam();
}

    public static void main (String [] args) throws FileNotFoundException, IOException {
        // Prompting the user to import the file of students
        System.out.println("1. Import from file");

        // Creating an arraylist of Students
        ArrayList<Student> students = new ArrayList<Student>();

        // Creating an object to choose a file with JFileChooser
        JFileChooser chooser = new JFileChooser();
        // Showing the dialog box and getting the chosen file from it
        int chosen = chooser.showOpenDialog(null);

        //getting the file
        File file = chooser.getSelectedFile();

        // inputting the file into the new Scanner object
        Scanner input = new Scanner(file);
        //input.useDelimiter(",");

        input.nextLine(); // We're going to ignore the first line from the file

        // Creating a while loop to read every line of the file (except the first)
        while (input.hasNextLine()) {
            // reading line per line
            String line = input.nextLine();
            //System.out.println("line 2" + line);

            // splitting the line up by commas
            String[] student = line.split(",");
            String lastName = student[0]; // getting the last name
            String firstName = student[1]; // getting the first name
            String username = student[2]; // getting the username
            String gradType = student[3]; // getting the graduation type (grad or undergrad)

            System.out.println("printing each:" + "\t " + lastName + "\t " + firstName + "\t " + username + "\t " + gradType);

            // Creating a student object
            Student studentObject = new Student(lastName, firstName, username, gradType);
            students.add(studentObject); // adding the student to the array list
        }

        System.out.println("Student List: " + students.toString());
    }
}
