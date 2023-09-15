/*
@ Maha Basheikh
Date: September 6, 2023
Problem 3
 */
public class Problem3 {

public static void main(String[] args) {
    int numOfPrimes = 50; // Number of prime numbers to show
    int numOfPrimesPerLine = 10; // numbers per line
    int count = 0; // counter to keep track of prime numbers
    int number = 2; // We'll start testing every integer starting from 2

    System.out.println("List of the first 50 prime numbers:  \r\n");

    // While loop to go through each integer
    while (count < numOfPrimes) {
        // Assume the number is prime
        boolean isPrime = true; // We initially assume the integer is a prime number

        int divisor; // Declaring the divisor

        // Iterating through every integer and testing whether they're prime by division
        for (divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
               isPrime = false; // If we've ruled the number out as a prime number, we set it to false
               break; // Exit the for loop to move onto the next integer
               }
           }

       // If the integer is prime
      if (isPrime) {
          count++; // Increase the count (since we need 50 prime numbers)

           if (count % numOfPrimesPerLine == 0) {
                // Printing the prime number
              System.out.println(number); // for the 10th number in the line, so the next line is a new line
                }
           else // Printing every non-10th number on the line
                System.out.print(number + " ");
           }

       // Check if the next number is prime
       number++;
        }
   }
}

/*
Introduction to Java Programming: Eleventh Edition, Y. Daniel Liang
Liang, Daniel. Introduction to Java Programming: Elevent Edition. Global Edition, Pearson, 2019
 */