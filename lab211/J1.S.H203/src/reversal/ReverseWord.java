
/*
 * Copyright(C) 2021, FPT university
 * J1.S.H203
 *  Reverse Word
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-09-14      1.0                 HuyTQ           First Implement
 */
package reversal;

import java.util.logging.Logger;
import java.util.Scanner;

/**
 * This class contains 2 method used to show the word in reverse order
 *
 * @author HuyTQ
 */
public class ReverseWord {

    /**
     * declare a final variable LOGGER to use logging for ReverseWord class
     */
    private static final Logger LOGGER = Logger.getLogger(ReverseWord.class.getName());

    /**
     * This method checks if inputString is empty or not. If it is empty, try
     * again
     *
     * @return a not empty string
     */
    private String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter input string: ");
            String inputString = scanner.nextLine().trim();// get input from the keyboard
            if (inputString.isEmpty()) {// if inputString is empty , try again
                LOGGER.warning("Input must be not empty, enter again");
            } else {
                return inputString; // if input is not empty then return
            }
        }
    }

    /**
     * This method receives a string and return the words in opposite order
     *
     * @param str is a parameter string
     * @return a string whose words are in reverse order and the first letter is
     * capitalized
     */
    private void printReverse(String str) {
        String[] listWords = str.trim().split(" "); //Use listWords contain words in str by spilitting str through space
        for (int i = listWords.length - 1; i >= 0; i--) {
            if (i == listWords.length - 1) {//Uppercase the first chracter of last word.
                System.out.print(listWords[i].replaceFirst(listWords[i].charAt(0) + "", listWords[i].toUpperCase().charAt(0) + "") + " ");
            } else if (i == 0) {//Lowwer case the first character of first word.
                System.out.print(listWords[i].replaceFirst(listWords[i].charAt(0) + "", listWords[i].toLowerCase().charAt(0) + ""));
            } else {
                System.out.print(listWords[i] + " ");
            }
        }
        System.out.println("");
    }

    /**
     * Main method run program to have the final result.
     *
     * @param args
     */
    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        String inputString = reverseWord.inputString();// Check valid input from the keybroard.
        reverseWord.printReverse(inputString);// Call method to have result.
    }
}
