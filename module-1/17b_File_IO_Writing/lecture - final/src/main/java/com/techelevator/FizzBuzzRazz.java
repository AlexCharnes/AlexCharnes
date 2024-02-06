package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
    1. Get the User input and output filenames
    2. Read the input file
    3. For each word in the input file lines
        - If the word length is 3 change it to FIZZ
        - If the word length is 5 change it to BUZZ
        - If the word length is 7 change it to RAZZ
        - otherwise don't change the word
    4. Write the new lines to the output file
    5. Tell the User the Process is finished
 */
public class FizzBuzzRazz {

    private final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Input file: ");
        String inputFileName = userInput.nextLine();

        System.out.print("Output file: ");
        String outputFileName = userInput.nextLine();

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try (Scanner inputFileReader = new Scanner(inputFile);
            PrintWriter printWriter = new PrintWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {


            while (inputFileReader.hasNextLine()) {
                List<String> newWords = new ArrayList<String>();
                String lineFromFile = inputFileReader.nextLine();

                String[] words = lineFromFile.split(" ");
               for (String word : words) {
                    if (word.length() == 3) {
                        newWords.add("Fizz");
                    } else if (word.length() == 5) {
                        newWords.add("Buzz");
                    } else if (word.length() == 7) {
                        newWords.add("Razz");
                    } else {
                        newWords.add(word);
                    }
               }

               String newLine = String.join(" ", newWords);

                bufferedWriter.write(newLine);
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Done!");


    }



}
