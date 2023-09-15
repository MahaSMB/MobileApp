import java.awt.*;

import java.io.File;

import java.util.Scanner;




public class Lab3P3 {




    public static void main (String[] args){

        System.out.println("Please enter the file name to Search");

        Scanner input = new Scanner (System.in);

        String filename = input.nextLine();




        searchFileName(filename);




    }

    public static void searchFileName(String filename){

        File file = new File(filename);




        if (file.exists()){

            System.out.println("The file exists.");

        } else {

            System.out.println("The file does not exist.");

        }




    }




}