
/*
 * Copyright(C) 2021, FPT university
 * J1.S.H208
 * SwapDigitsPairs
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-29      1.0                 HuyTQ            First Implement
 */
package digitspairs;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains three methods to get a positive integer number and swap
 * pairs digits .
 *
 * @author HUYTQ
 */
public class SwapDigits {

    /**
     * This method require user to enter positive number from keyboard.
     *
     * @return a positive integer number.
     */
    private int getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(SwapDigits.class.getName());// This a a variable logger used to log out result to console.
        while (true) {
            try {
                System.out.print("Enter a positive integer: ");
                int inputNumber = Integer.parseInt(scanner.nextLine().trim());
                if (inputNumber <= 0) {//If input is a negative number then enter input again.
                    logger.warning("Please enter a positive integer.");
                } else {
                    return inputNumber;
                }
            } catch (NumberFormatException e) {// If input is not a integer number.
                logger.warning("Please enter a positive integer.");
            }
        }
    }

    /**
     * This method is used to find 2 digits into a pair and swap them.
     *
     * @param n is input number.
     * @return a number after swap every pairs.
     */
    private int swapDigitPairs(int n) {
        int result = 0;// Initialize a variable as result.
        /*
         * This is a special variable to calculate the result.
         * It represents the position of the digit in the result.
         * For example, factor =1 represent unit, factor=10 represent dozen, factor =100 represent hundred...
         */
        int factor = 1;

        while (n > 0) {
            int firstDigitInPair = n % 10;// find firstDigitInPair
            n = n / 10;// decrease n 10 time after finding firstDigitInPair

            if (n == 0) {// This is a condition to return result if the number contains an odd number of digits.
                result += factor * firstDigitInPair;
                break;
            }

            int secondDigitInPair = n % 10;//find second digit in a pair.
            n = n / 10;
            result = result + factor * 10 * firstDigitInPair + factor * secondDigitInPair;// add 2 digits into result.
            factor *= 100;
        }

        return result;
    }

    /**
     * This main method is used to run this program. Create object, call method
     * getInputNumber and swapDigitPairs.
     *
     * @param args
     */
    public static void main(String[] args) {
        SwapDigits swapDigits = new SwapDigits();
        int inputNumber = swapDigits.getInputNumber();// Initialize getInputNumber throgh method getInputNumber.
        System.out.println("Number after swap: " + swapDigits.swapDigitPairs(inputNumber));// Call method swapDigitPairs and  print result through console.
    }

}
