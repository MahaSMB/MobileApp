import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Hwk_Sep6 {
    public static void main(String[] args) {
        /*
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
         */

       // 1.) Initializing arrays with input values
        int[] inputArray = {5, 3 , 9, 7, 4};

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
            int randomIndexToSwap = random.nextInt(inputArray.length); //
            int tempVariable = inputArray[randomIndexToSwap]; //
            inputArray[randomIndexToSwap] = inputArray[i]; //
            inputArray[i] = tempVariable; //
        }

        System.out.println(Arrays.toString(inputArray));

       // 8.) Shifting elements
       //ArrayUtils.shift(randomArray, 3); Apache Java

        //
        int tempVariable2 = randomArray[0]; // keeping the initial element to avoid an index out of bounds error

        //
        for (int i = 1; i < randomArray.length; i++) {
            randomArray[i - 1] = randomArray[i];
        }

        //
        randomArray[randomArray.length - 1] = tempVariable2;

        // Printing the result
        System.out.println(Arrays.toString(randomArray));
    }
}


/* References used
https://www.digitalocean.com/community/tutorials/shuffle-array-java
https://www.baeldung.com/array-processing-commons-lang
http://www.java2s.com/ref/java/java-array-shift-elements.html
 */