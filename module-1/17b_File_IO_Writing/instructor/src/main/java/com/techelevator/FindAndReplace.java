package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFileName = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFileName = userInput.nextLine();
        
        try (Scanner reader = new Scanner(new File(sourceFileName));
             PrintWriter writer = new PrintWriter(new File(destinationFileName))) {

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                line = line.replaceAll(searchWord, replacementWord);
                writer.println(line);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
