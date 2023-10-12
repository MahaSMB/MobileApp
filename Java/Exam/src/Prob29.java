import java.util.Scanner;

/*
29. Write a program that counts the number of lowercase letters in a string. Your program should prompt the user
 to enter the string and display the count.
 */
public class Prob29 {
    public static void main (String [] args) {
        //prompint the user
        System.out.println("Please enter a string (of letters):");

        //initializing the counter for counting the number of lowercase letters
        int counter = 0;

        // creating a Scanner object for reading screen input
        Scanner input = new Scanner(System.in);
        // initializing the string from the input object
        String userInput = input.nextLine();

        // for loop to iterate through the string char by char
        for (int i = 0; i < userInput.length(); i++) {
            // using the ASCII table as can be referenced here:
            // https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

            // Iterating through the string given char by char
            char character = userInput.charAt(i);

            // if a char's value falls between 97 and 122 inclusive, it's a lowercase letter
            if (character >= 97 && character <= 122) {
                // and we increase the counter
                counter++;
            }
        }

        // Closing the input stream of the counter
        input.close();

        // Printing the result to screen
        System.out.println("The number of lowercase letters in your string is: " + counter);
    }

}
