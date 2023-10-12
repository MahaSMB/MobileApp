import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Arrays;

/*
Write a program; that stores an array of the five int values 1, 2, 3, 4 and 5,
aDate object for the current time,
and the double value 5.5 into the file namedTest.dat.
 */
public class Prob26 {
    public static void main (String [] args) {
        // initializing the array
       int[] array = {1, 2, 3, 4, 5};

       //initializing the date value
       Date current = new Date();

       //initializing the double value
       double value = 5.5;

       //System.out.println(Arrays.toString(array) + "\n" +  current + "\n" + value);

        // try clause in case of errors
        try {
            // Creating a File object that will open a file with the given name
            File myData = new File("Test.dat");
            // Creating an object that will be used to write to the given file
            FileWriter myWriter = new FileWriter("Test.dat");
            //Writing with the FileWriter object. We write the array, the time and the double value
            myWriter.write(Arrays.toString(array) + "\n" +  current + "\n" + value);

            // closing the writing stream
            myWriter.close();

            // letting the user know that the file was written successfully
            System.out.println("Successfully wrote to the file.");
            // if the file was created successfully, print the following to screen
            if (myData.createNewFile()) {
                System.out.println("File created: " + myData.getName());
            }
            else { // if the file already exists, print the following statement to screen
                System.out.println("File already exists.");
            }
            // Catching the Exception
        } catch (IOException e) { // If an IO Exception occurs, print the following to screen
            System.out.println("An error occurred.");
            e.printStackTrace(); // as well as the stack trace
        }

    }
}
