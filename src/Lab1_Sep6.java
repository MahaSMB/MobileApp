import java.util.Scanner;

/*
@ Maha Basheikh
 */
public class Lab1_Sep6 {

    public static void main(String[] args) {
        int menuOption = 1;
        while (menuOption != 0) {
            System.out.println("Please choose one of the following:");
            System.out.println("1.\tMy name");
            System.out.println("2.\tMy programming background");
            System.out.println("3.\tSome projects I worked on");
            System.out.println("0.\tExit");

            Scanner input = new Scanner(System.in);
            //int menuOption = input.nextInt();
            //System.out.println("");

            if (menuOption == 1) {
                System.out.println("My name is Syeda Ahmed.");
            }
            else if (menuOption == 2) {
                System.out.println("I have a degree in Computer Engineering from Ryerson. " +
                        "I have not yet have much professional experience. ");
            }
            else if (menuOption == 3) {
                System.out.println("List of previous Java Projects. " +
                        "a) Java Banking Projects ");
            }
            else if (menuOption == 0) {
               break;
            }
            else {
                System.out.println("Wrong option chosen. Please try again.");
            }

        }
        System.out.println("Exiting now.");
    }
}



