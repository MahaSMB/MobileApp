import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class Lab3P2{
    public static void main(String[] args) throws IOException{

        // Reading the SourceFIle
        File file = new File("myFile1.txt");
        try{
            Scanner input1 = new Scanner(file);
            System.out.println("Current content of the Source file is:");
            while (input1.hasNextLine()){ // Prints until reaches End of the line
                System.out.println(input1.nextLine()); // Prints the first line.
                //content.append(input.nextLine()).append("\n");
            }
            input1.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found:" + file);
            e.printStackTrace();
        }
        // Ask the user for the new Content to replace old content.
        System.out.println("Please enter the new content to replace: ");
        Scanner input = new Scanner(System.in);
        String newFileContent = input.nextLine();
        replaceStringFromSourceToTarget("myFile1.txt", "myFile2.txt", newFileContent );
    }

    public static void replaceStringFromSourceToTarget(String sourceFileName, String targetFileName, String newString) throws IOException{

        // Overwrite the source file
        FileWriter writer = new FileWriter(sourceFileName);
        writer.write(newString);
        writer.close();

        // Check if the Target file exist if not then create
        // Then write content in the Target file
        File targetFile = new File(targetFileName);
        if (targetFile.exists()) {
            System.out.println(targetFileName + " already exists.");
            return; // Exit the function if the target file already exists
        }
        else{
            FileWriter writer2 = new FileWriter(targetFileName);
            writer2.write(newString);
            System.out.println("New Content " + newString +  " has been " +
                    "written to the " + targetFileName + " file successfully.");
            writer2.close();
        }
    }
}
