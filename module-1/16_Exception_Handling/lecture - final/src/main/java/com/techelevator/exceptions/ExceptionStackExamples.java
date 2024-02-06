package com.techelevator.exceptions;

import java.util.Locale;

/*
    Demonstrates how exceptions propagate throw the stack
 */
public class ExceptionStackExamples {

    public static void main(String[] args) {
        System.out.println("main method start");
        try {
            methodA();
        } catch (NullPointerException e) {
            System.out.println("String was null");
        }
        System.out.println("main method end");
    }
    private static void methodA() {
        System.out.println("methodA start");
//        try {
            methodB();
//        } catch (NullPointerException e) {
//            System.out.println("String was null");
//        }
        System.out.println("methodA end");
    }

    private static void methodB() {
        System.out.println("methodB start");
//        int[] arr = {1,2,3};
//        int x = arr[5];
        methodC();
        System.out.println("methodB end");
    }

    /*
    Exceptions when thrown can be caught in any method in the current
    call stack.  They do not need to be caught here, but can be caught in methods
    that call this method.
     */
    private static void methodC() {
        System.out.println("methodC start");
        String str = null;
        str.toUpperCase();
        System.out.println("methodC end");
    }

}
