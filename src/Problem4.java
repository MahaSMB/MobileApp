
import java.util.Scanner;
/*
@ Maha Basheikh
Date: September 6, 2023
Problem 4
 */
public class Problem4 {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Declaring the initial two operands and the result variables
        double n1, n2, result;

        // Declaring the operator char
        char op;

        // Getting the input from the user
        n1 = getNumber(input);
        op = getOperator(input);
        input.nextLine();
        n2 = getNumber(input);

        // Making sure the user doesn't divide by zero
        if(op == '/' && n2 == 0) { // If the user enters a division operator and the denominator is a 0, exit the calculation
            System.out.println("Cannot divide a number by 0");
            System.exit(0);
        }

        result = getResult(n1,op,n2); // saving the result of the first term

        // Entering a while loop to allow the user to enter more operators and operands
        while(true) {
            System.out.println(n1 + " " + op + " " + n2 + " = " + result);  // Printing the ongoing result
            n1 = result;
            op=getOperator(input); // getting the operator from the user (using getOperator method)
            if(op == '=') // exiting the loop if an equal sign is used, signalling that the calculation is complete
                break;
            n2 = getNumber(input); // getting the operand from the user (using the getNumber method)
            if(op == '/' && n2 == 0) { // Exiting the calculation if the user tries to divide by zero
                System.out.println("Cannot divide a number by 0");
                System.exit(0);
            }
            result = getResult(n1,op,n2); // getting the final result
        }
        System.out.println("The final result is " + result); // Printing the final result after entering an '=' sign
        input.close(); // closing the input stream
    }
    public static double getNumber(Scanner input) { // Function to get the operand
        while(true) {
            System.out.println("Enter a number:"); // user prompt
            if(!input.hasNextDouble()) { // if user doesn't enter a real number, we tell them to try again
                System.out.println("Wrong input, please try again");
                System.out.println("Please enter a real number");
                input.nextLine();
                continue;
            }
            else
            {
                return input.nextDouble(); // reading the real number the user enters
            }
        }
    }
    public static char getOperator(Scanner input) { // Function to get the operator from the user
        while(true) {
            char op;
            System.out.println("Enter an operator"); // user prompt
            op = input.next().charAt(0); // reading the operator from the user
            if(op == '+' || op=='-' || op=='*' || op =='/' || op == '=') { // allowed operators
                return op; // passing the char to the calling method
            }
            else {
                System.out.println("Wrong operator, press enter to try again"); // if a wrong operator is entered, we tell the user to try again (go back to the beginning of the loop
                continue;
            }
        }
    }
    public static double getResult(double n1, char op, double n2) { // Function to get the result
        double result=0; // setting the result to an initial value of 0
        switch (op) { // The following are switch cases for the addition, subtraction, multiplication and division
            // (in order)for the user given operands. The result is returned to caller.
            case '+': result =  n1+n2;
                break;
            case '-': result =  n1-n2;
                break;
            case '*': result =  n1*n2;
                break;
            case '/': result = n1/n2;
                break;
        }
        return result;
    }
}
