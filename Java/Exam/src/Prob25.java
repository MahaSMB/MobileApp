import java.util.Scanner;

/*
   25. Write a method that takes two number and divides them without using ‘/’ division operator.
    */
public class Prob25 {
    public static void main (String[] args){

        System.out.println("\n Please enter two real numbers to be divided and then press enter:");

        // Getting the result from the function
        double result = division();

        // Printing out the result to screen
        System.out.println("Your result is: " + result);

    }
    // Method attributes and signatures
    public static double division() {

        // Variables we'll need to perform the calculations
        double dividend = 0;
        double divisor = 0;

        // Creating the Scanner object we'll need to get input from the user
        Scanner input = new Scanner(System.in);

        // Using a while loop for data validation
        while(input.hasNextInt()) {
            // getting the dividend from the user
            dividend = input.nextInt();
            // getting the divisor from the user
            divisor = input.nextInt();

            // if the divisor is 0, tell the user to input another number with an if statement
            if (divisor == 0) {
                System.out.println("The divisor cannot be 0! Please try again.");
            }
            else break;
        }
        input.close(); // closing the input stream

        // Initialize and store the sign of the result that we'll be using
        int sign = 1;

        // if the product of the dividend and divisor is greater than zero, set the sign as negative
        if (dividend * divisor < 0) {
            sign = -1;
        }

        // Convert both dividend and divisor to positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Set the quotient to zero
        int quotient = 0;

        // Create a while loop and set the condition for it to continue until the dividend is greater than the divisor
        while (dividend >= divisor)
        {
            // Reduce the dividend by the divisor in each iteration
            dividend = dividend - divisor;

            // increase quotient by one in each iteration
            quotient++;
        }

        System.out.println("The remainder is " + dividend);
        return sign * quotient;
    }


}
