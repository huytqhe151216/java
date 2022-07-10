/*
 * Copyright(C) 2005, FPT university
 * J1.S.H207
 * secondHalfLetters
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-01      1.0                 HuyTQ            First Implement
 */
package countletter;

import java.util.Scanner;

/**
 * This class contains the methods getInputString, findNumberLetter and the
 * main function to count  and display the number of letters in the second half
 * of the alphabet.
 *
 * @author HUYTQ
 */
public class SecondHalfLetters {

    /**
     * This method is used to get input string by user and return it.
     *
     * @return the entered string after lower case.
     */
    private String getInputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        return scanner.nextLine().trim().toLowerCase();
    }

    /**
     * This method checks duplicate and display the number of letters in the
     * second half of the alphabet.
     *
     * @param inputString the string to count.
     */
    private void findNumberLetter(String inputString) {
        int result = 0;//the number of second half letter.
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= 'n' && inputString.charAt(i) <= 'z') {//check letter in second half letters.
                boolean isDuplicate = false;
                for (int j = i + 1; j < inputString.length(); j++) {//check duplicate.
                    if (inputString.charAt(i) == inputString.charAt(j)) {
                        isDuplicate = true;
                    }
                }
                if (isDuplicate == false) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * This main method is used to create new object and call method to run.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SecondHalfLetters numberOfLetter = new SecondHalfLetters();//Create an object of SecondHalfLetters.
        String inputString = numberOfLetter.getInputString();//Get input string by user.
        numberOfLetter.findNumberLetter(inputString);//Call findNumberLetter method to process and print the result.
    }
}
