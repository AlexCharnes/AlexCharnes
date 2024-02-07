package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws IOException, FileNotFoundException {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() throws IOException {
        /* Your code goes here */

        System.out.print("What is the search word? ");
        String wordBeingReplaced = userInput.nextLine();

        System.out.print("What is the replacement word? ");
        String newWord = userInput.nextLine();

        System.out.print("What is the source file? ");
        String inputFileName = userInput.nextLine();

        System.out.print("What is the destination file? ");
        String outputFileName = userInput.nextLine();

        File inputFile = new File(inputFileName);

        File outputFile = new File(outputFileName);





        if (!inputFile.exists()){
            System.out.println("This is an invalid file selection");
        }
        try (Scanner textScanner = new Scanner(inputFile);
             PrintWriter printWriter = new PrintWriter(outputFile);){
            while (textScanner.hasNextLine()){
                String line = textScanner.nextLine();
                if (line.contains(wordBeingReplaced)){
                    line = line.replaceAll(wordBeingReplaced, newWord);
                }
                printWriter.println(line);



            }



        }catch (FileNotFoundException e){
            System.out.println("Input file not found");
        }catch (IOException e){
            System.out.println("Error writing to file");
        }


    }

}
