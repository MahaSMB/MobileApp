public class Problem3 {

2 public static void main(String[] args) {
            3 final int NUMBER_OF_PRIMES = 50; // Number of primes to display
            4 final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
            5 int count = 0; // Count the number of prime numbers
            6 int number = 2; // A number to be tested for primeness
            7
            8 System.out.println("The first 50 prime numbers are \n");
            9
            10 // Repeatedly find prime numbers
            11 while (count < NUMBER_OF_PRIMES) {
                12 // Assume the number is prime
                13 boolean isPrime = true; // Is the current number prime?
                14
                15 // Test whether number is prime
                16 for (int divisor = 2; divisor <= number / 2; divisor++) {
                    17 if (number % divisor == 0) { // If true, number is not prime
                        18 isPrime = false; // Set isPrime to false
                        19 break; // Exit the for loop
                        20 }
                    21 }
                22
                23 // Display the prime number and increase the count
                24 if (isPrime) {
                    25 count++; // Increase the count
                    26
                    27 if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                        28 // Display the number and advance to the new line
                        29 System.out.println(number);
                        30 }
                    31 else
                    32 System.out.print(number + " ");
                    33 }
                34
                35 // Check if the next number is prime
                36 number++;
                37 }
            38 }
39 }
}
