import java.util.Scanner;

/*
@ Maha Basheikh
Date: September 6, 2023
Problem 2
 */
public class Problem2 {
    public static void main(String[] args) {

        // Declaring the two natural numbers
        int n1, n2;

        // Creating a Scanner object to read input from the user's keyboard
        Scanner input = new Scanner(System.in);


        while(true) {

            // user prompt
            System.out.println("Enter number 1:");

            // reading the first number from the user
            n1 = input.nextInt();
            if (n1 <= 0) { // making sure the number is a natural number
                System.out.println("Please enter a natural integer >0");
                continue;
            }
            else
                break;
        }
        while(true) {
            System.out.println("Enter number 2:");

            // reading the second number from the user
            n2 = input.nextInt();
            if(n2 <= 0) { // making sure the number is a natural number
                System.out.println("Please enter a natural integer >0");
                continue;
            }
            else
                break;
        }
        input.close(); // Closing the input stream

        // Printing the user's chosen numbers
        System.out.println("The numbers entered are " + n1 + " and " + n2);

        // Finding the smallest of the numbers
        int k = Math.min(n1, n2);

        // From the smaller number, we decrease by one in a for loop and find a number that is divisible to both. The
        // first one we find is the greatest common divisor
        for( ; k >= 1; k--) {
            if((n1 % k == 0) && (n2 % k == 0)) break; // once found, we exit the loop
        }
        System.out.println("The greatest common factor of " + n1 + " and " + n2 + " is " + k); // print the result
    }
}