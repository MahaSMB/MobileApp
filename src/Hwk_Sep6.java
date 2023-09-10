import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
@ Maha Basheikh
Date: September 6, 2023
Homework 1
 */
public class Hwk_Sep6 {
     public static void main(String[] args) {

       // 1.) Initializing arrays with input values

         // Creating a Scanner object 'input' to get data from the user's keyboard
         Scanner input = new Scanner(System.in);
         System.out.println("Please enter 5 integers."); // user prompt

         int[] inputArray = new int[5]; // initializing the array

         // Populating the array with the user's input
         for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] =  input.nextInt();
         }

        // Printing out the above array by using the Array's class toString method
        System.out.println("Input Array: " + Arrays.toString(inputArray));

       // 2.) Initializing arrays with random values
        int[] randomArray = new int[5];

        // Creating a random object and initializing it
        Random random = new Random();

        // For loop to iterate through the randomArray and use random to generate a pseudo-random number (between 0
        // and 100) to initialize randomArray with
        for (int i = 0; i < randomArray.length; i++) randomArray[i] = random.nextInt(100);

       // 3.) Printing arrays
        System.out.println("Random array: " + Arrays.toString(randomArray)); // printing out the randomArray

       // 4.) Summing all elements

        // Initializing an integer to hold the sum of all the array elements
        int arrayTotal = 0;

        // For loop to iterate and sum all the elements
        for (int i = 0; i < inputArray.length; i++) arrayTotal += inputArray[i];

        // Printing out the sum
        System.out.println("The inputArray total is: " + arrayTotal);

       // 5.) Finding the largest element
        // initializing a max element variable
        int maxElement = 0;

        // For loop to iterate through the array and compare each element to maxElement to find the largest one
       for (int i = 0; i < randomArray.length; i++) {

           // comparing each array element to maxElement and only reassigning to maxElement if it's larger than the
           // current maxElement
           if (randomArray[i] > maxElement) maxElement = randomArray[i];
       }
       // printing out the result
        System.out.println("The largest element is: " + maxElement);

       // 6.) Finding the smallest index of the largest element

        // Creating a new array with repeating max value
        int[] repeatMax = { 5, 93, 26, 71, 93, 42, 69, 24, 13, 3 };

        // initializing the max element variable
        int maxElement2 = 0;

        // initializing the smallest index variable
        int smallestIndex= 0;

        // iterating through the for loop to do the following
        for (int i = 0; i < repeatMax.length; i++) {
            if (repeatMax[i] > maxElement2) { // comparing each element against the max element and if it's bigger
                maxElement2 = repeatMax[i]; // set it as the biggest element and
                smallestIndex = i;  // note down its index value
            }
        }
        // Print out the result
        System.out.println("For the repeatMax " + Arrays.toString(repeatMax) + " array, with the largest element " +
                "being " + maxElement2 + " the smallest" + "index is " + smallestIndex + ".");

       // 7.) Random shuffling
        for (int i = 0; i < inputArray.length; i++) {
            // Generating a pseudo-random number from 0 to the length of the array, and assigning that number to the
            // random index
            int randomIndexToSwap = random.nextInt(inputArray.length);
            //Assigning the array value of that random index to a temp value
            int tempVariable = inputArray[randomIndexToSwap];

            //Assigning the current value of the iteration to the previously saved array value of the random index
            inputArray[randomIndexToSwap] = inputArray[i]; //

            // Assigning the previously saved temp value to current value of the iteration (a swap algorithm with more
            // than two values)
            inputArray[i] = tempVariable;
        }

        // Printing the value of the array after the shuffle
        System.out.println(Arrays.toString(inputArray));

       // 8.) Shifting elements
       //ArrayUtils.shift(randomArray, 3); Apache Java


        int tempVariable2 = randomArray[0]; // keeping the initial element to avoid an index out of bounds error

        // Iterating through the array and shifting the elements one position to the left
        for (int i = 1; i < randomArray.length; i++) {
            randomArray[i - 1] = randomArray[i];
        }

        // Restoring the initially saved value
        randomArray[randomArray.length - 1] = tempVariable2;

        // Printing the result
        System.out.println(Arrays.toString(randomArray));
        input.close();
    }
}


/* References used
https://www.digitalocean.com/community/tutorials/shuffle-array-java
https://www.baeldung.com/array-processing-commons-lang
http://www.java2s.com/ref/java/java-array-shift-elements.html
 */