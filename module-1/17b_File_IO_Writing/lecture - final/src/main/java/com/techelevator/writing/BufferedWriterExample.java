package com.techelevator.writing;

import java.io.*;

public class BufferedWriterExample {

    public static void main(String[] args) {

        /*
         * Create a file and PrintWriter
         */
        File ourBufferedFile = new File("bufferedFile.txt");

        /*
         * To add buffering a Print Writer is still needed and will still do the writing.
         * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
         * write to the file and the buffered writer will provide buffering.
         */
        try ( PrintWriter printWriter = new PrintWriter(ourBufferedFile);
             BufferedWriter bufferedWriter = new BufferedWriter(printWriter) ) {

            bufferedWriter.write("This is our first line of buffered text");
            bufferedWriter.newLine();

            bufferedWriter.write("This is the second line");
           bufferedWriter.newLine();

        } catch (FileNotFoundException e) {
            System.out.println("Your file was not found");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }
}
