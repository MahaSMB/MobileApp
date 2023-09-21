//
//  main.m
//  Sep19_MahaBasheikh
//
//  Created by user248611 on 9/19/23.
//

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
                
        // Part 1
        // What is xCode?
        NSLog(@"xCode is an IDE for macOS that's used to develop software within Apple's ecosystem (iOS etc.)");
        // How many versions of xCode do you have? 2
        NSLog(@"There are 2 versions of xCode installed on this MacinCloud.");
        // 1 Your Name: Maha Basheikh
        NSLog(@"My name is Maha Basheikh.");
        // 2 My guess on my Java exam grade: 85
        NSLog(@"My guess is I got an 85 on the Java exam.");
        
        // Part 2
        // 1. Initializing arrays with input values
        
        // Declaring the array
        int inputArray[5];
        
        // creating the for loop
        for (int i = 0; i < (sizeof(inputArray)/sizeof(inputArray[0])); i++) {
            printf("inputArray[%d]=", i); //prompting the user
            scanf("%d", &inputArray[i]); // reading the screen with the user's input and initializing the array
        }
    
        // 2. Initializing arrays with random values
        int lowerBound = 0; // creating the lower bound
        int upperBound = 100; // creating the upper bound
        int randomValue = 0; // initializing the random value integer
        
        int randomArray[5]; // declaring the array with 5 values
        
        for (int i = 0; i < (sizeof(randomArray)/sizeof(randomArray[0])); i++) {
            randomValue = lowerBound + arc4random() % (upperBound - lowerBound); // initializing a random value with the bounds set
            randomArray[i] = randomValue; // using the random value to initialize the array
            printf("\nrandomArray[%d]=", randomValue); // printing the value so we can see it
        }
        
        // 3. Printing arrays
        
        printf("\n");
        
        for (int i = 0; i < 5; i++) {
            printf("inputArray[%d]= %d\n", i, inputArray[i]); // printing the input array value in a for loop
        }
        
        printf("\n");
        
        for (int i = 0; i < 5; i++) {
            printf("randomArray[%d]= %d\n", i, randomArray[i]); // printing the random array value in a for loop
        }
        // 4. Summing all elements
        
        int arrayTotal = 0; // creating a value to sum up the array
        
        
        // iterating through the array one by one and adding up all the values
        for (int i = 0; i < (sizeof(inputArray)/sizeof(inputArray[0])); i++) {
            arrayTotal += inputArray[i];
        }
        
        printf("The inputArray total is: %d", arrayTotal); // printing the value to the screen
        
        printf("\n"); // creating a new line for readibility
        
        // 5. Finding the largest element
        int maxElement = 0; //initializing a max value
        
        
        // iterating through the randomArray values
        for (int i = 0; i < (sizeof(randomArray)/sizeof(randomArray[0])); i++) {
            if (randomArray[i] > maxElement) maxElement = randomArray[i]; // if the value is higher than the already set maxElement, set as new maxElement
        }
        
        printf("For the randomArray largest element is %d", maxElement); // print the maxElement
        printf("\n");
        
        // 6. Finding the smallest index of the largest element
        
        // Creating a new array with a repeating max value
        int repeatingMaxValue[] = {22, 35 , 66, 73, 39, 98, 25, 65, 13, 98}; // initializing a new array with a repeating max value
        
        int maxElement2 = 0; // initializing a max element
        
        int smallestIndex = 0; // initializing a new smallest index
        
        
        // iterating through the repeating max value array and finding the first value to store as the highest value (not looking for repeats of same value)
        for (int i = 0; i < (sizeof(repeatingMaxValue)/sizeof(repeatingMaxValue[0])); i++) {
            if (repeatingMaxValue[i] > maxElement2) {
                maxElement2 = repeatingMaxValue[i];
                smallestIndex = i; // saving the index of the max value
            }
        }
        
        printf("\nFor the following array:\r\n");
        
        for (int i = 0; i < (sizeof(repeatingMaxValue)/sizeof(repeatingMaxValue[0])); i++) { // printing the array so we can see what the array is
            printf("\nrepeatingMaxValue[%d]=", randomArray[i]);
        }
        
        printf("The smallest index is %d", smallestIndex); // printing out what the smallest index is
        printf("\n");
        
        // 7. Random shuffling
        lowerBound = 0; // using the same lower bound as before
        upperBound = sizeof(randomArray)/sizeof(randomArray[0]); // setting the upper bound to be the size of the array
        
        // This is basically a swap algorithm with more than two values
        for (int i = 0; i < (sizeof(randomArray)/sizeof(randomArray[0])); i++) {
            int randomIndexToSwap = lowerBound + arc4random() % (upperBound - lowerBound); // generating a random number and assigning it to the random index
            int tempVariable = randomArray[randomIndexToSwap]; // Getting the value at that index and assigning to a temp value
            randomArray[randomIndexToSwap] = randomArray[i]; // saving the current iteration to the value of the random index
            randomArray[i] = tempVariable; // taking the previously saved temp value and saving it back into current iteration
        }
        
        // Printing the result
        printf("\n");
        
        for (int i = 0; i < (sizeof(randomArray)/sizeof(randomArray[0])); i++) {
            printf("\nrandomArray[%d]=", randomArray[i]); // printing the result of the shifting elements
        }
        
        
        // 8. Shifting elements
        int INPUTARRAYLENGTH= sizeof(inputArray)/sizeof(inputArray[0]); // setting a constant value for the length of the array
        
        int temp = inputArray[0]; // Saving the first value of the array
        
        // iterating through the array and shifting each value to the left
        for (int i = 0; i < INPUTARRAYLENGTH; i++) {
            inputArray[i - 1] = inputArray[i]; // shifting each element one position to the left
        }
        inputArray[INPUTARRAYLENGTH - 1] = temp; // restoring the first value of the array
        
        printf("\n");
        
        for (int i = 0; i < (INPUTARRAYLENGTH); i++) {
            printf("\ninputArray[%d]=", inputArray[i]); // printing the result of the shifting
        }
        
    }
    return 0;
}
