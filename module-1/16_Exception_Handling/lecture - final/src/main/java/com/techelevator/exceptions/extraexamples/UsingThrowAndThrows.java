package com.techelevator.exceptions.extraexamples;

import com.techelevator.exceptions.IncorrectStringValueException;

import java.io.FileNotFoundException;

public class UsingThrowAndThrows {

    public static void main(String[] args) throws FileNotFoundException {


        try {
            thisMethodThrowsAFileNotFoundException();
            thisMethodThrowsOurCustomException();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectStringValueException e) {
            System.out.println("Our custom Message: " + e.getMessage());
            System.out.println("The original String: " + e.getOriginalString());
        } catch (Exception e) {
            //  NEVER DO THIS!!!
        }

        thisMethodThrowsANullPointerException();
    }

    private static void thisMethodThrowsANullPointerException() {
        throw new NullPointerException();
    }

    private static void thisMethodThrowsAFileNotFoundException() throws FileNotFoundException{
        //throw new FileNotFoundException("here the filename");
    }

    private static void thisMethodThrowsOurCustomException() throws IncorrectStringValueException {
        throw new IncorrectStringValueException("This is the message", "This is the custom property");
    }
}
