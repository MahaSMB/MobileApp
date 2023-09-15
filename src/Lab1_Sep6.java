import java.util.Scanner;

/*
@ Maha Basheikh
Date: September 6, 2023
Lab 1
 */
public class Lab1_Sep6 {

    public static void main(String[] args) {

        // Setting the menu option as 1 so we can enter the while loop
        int menuOption = 1;

        //The while loop will run until the user enters a 0 to exit
        while (menuOption != 0) {

            //Showing the user the menu options
            System.out.println("Please choose one of the following:");
            System.out.println("1.\tMy name");
            System.out.println("2.\tMy programming background");
            System.out.println("3.\tSome projects I worked on");
            System.out.println("0.\tExit");



            // Creating a Scanner object in order to receive keyboard input from the user
            Scanner input = new Scanner(System.in);

            menuOption = input.nextInt();

            // Creating if/else clauses for the options the user has
            if (menuOption == 1) {
                System.out.println("My name is Maha Basheikh. \n"); // my name
            }
            else if (menuOption == 2) { // My programming background
                System.out.println("I have just completed my degree in Computer Science from Algoma University. \r\n" +
                        "\tI do not currently have any work experience as a software developer. \n");
            }
            else if (menuOption == 3) { // My projects
                System.out.println("I have built a few websites from scratch using pure HTML and CSS, one website using\r\n" +
                        " \tReact and have completed a few projects in Java. Other than that I have completed course work\r\n" +
                        "\tin various programming languages such as C++, Assembly, SQL, Python and Fortran. \n");
            }
            else if (menuOption == 0) { // Giving the user an option to exit by pressing 0
               break;
            }
            else { // in case anything besides the above options are selected
                System.out.println("Wrong option chosen. Please try again. \n");
            }
            input.close(); // Close the input stream
        } // Letting the user know we are exiting the program
        System.out.println("Exiting now.");

    }
}



