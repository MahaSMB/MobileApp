import java.util.Random;
import java.util.Scanner;
/*
@ Maha Basheikh
Date: September 6, 2023
Problem 1
 */
public class Problem1 {
    public static void main(String[] args) {

        // Creating a Scanner object to receive input from the user's keyboard
        Scanner input = new Scanner(System.in);

        //Creating a Random object to generate random integers
        Random randomInt = new Random();

        // generating a random integer between 0 and 100
        int randomNo = randomInt.nextInt(101);
        //System.out.println("Random number: " + randomNo);

        // Printing out the generated integer
        System.out.println("The random number generated is: " + randomNo);
        int userChoice; // Declaring the variable for the user's choice
        do {
            System.out.println("Enter a number:"); // prompting the user to enter their choice
            userChoice = input.nextInt(); // reading the user's choice from the keyboard
            if(userChoice == randomNo) { // if the user guesses right
                System.out.println("Congratulations! The input matches the random number generated :)");
                break; // exiting the do while loop
            }
            else if(userChoice > randomNo) { // If the user's guess is higher than the number
                if((userChoice - randomNo)>10){ // if the user's guess is within 10 and greater than the number
                    System.out.println("The number is too high. Please retry!");
                } // if the user's guess is greater than the number by less than 10
                else System.out.println("The number you entered is close but too high. Please retry!");
            }
            else {
                if((randomNo - userChoice)>10) { // if the user's guess is within 10 and less than the number
                    System.out.println("The number is too low. Please retry!");
                }
                else // // if the user's guess is less than the number by less than 10
                    System.out.println("The number you entered is close but too low. Please retry!");
            }
        } while (userChoice != randomNo); // stay in the loop as long the user guesses wrong
        input.close(); // close the input stream
    }
}