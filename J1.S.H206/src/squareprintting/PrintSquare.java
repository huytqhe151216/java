/*
 * Copyright(C) 2005, FPT university
 * J1.S.H206
 * printSquare
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-10-24      1.0                 HuyTQ            First Implement
 */
package squareprintting;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains 3 methods getInputNumber , printSquare and main to print
 * square by number.
 *
 * @author HUYTQ
 */
public class PrintSquare {

    /**
     * Declare a final variable LOGGER to use logging for class.
     */
    private static final Logger LOGGER = Logger.getLogger(PrintSquare.class.getName());

    /**
     * Declare a final variable SCANNER to get input for class.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This method is used to get range of square.
     *
     * @param message for input
     * @return range is valid with the condition.
     */
    private int getInputNumber(String message) {
        while (true) {
            try {
                System.out.print(message);
                int inputNumber = Integer.parseInt(SCANNER.nextLine());
                return inputNumber;// if inputNumber is a integer then return.
            } catch (NumberFormatException e) {
                LOGGER.warning("Wrong input format. Please try again.");
            }
        }
    }

    /**
     * This method is used to draw a square by number.
     *
     * @param minValue of square
     * @param maxValue of square
     */
    private void printSquare(int minValue, int maxValue) {
        int i = minValue;
        while (i <= maxValue) {
            int j = i;
            while (j <= maxValue - minValue + i) {
                if (j <= maxValue) {
                    System.out.print(j);
                } else {
                    System.out.print(j - maxValue + minValue - 1);
                }
                j++;
            }
            i++;
            System.out.println("");
        }
    }

    /**
     * This main method is used to run this program.Create object to call method
     * getInputNumber and printSquare.
     *
     * @param args default parameter.
     */
    public static void main(String[] args) {
        PrintSquare printSquare = new PrintSquare();//Create object to call methods.
        int minValue = printSquare.getInputNumber("Enter min value:");
        int maxValue = Integer.MIN_VALUE;
        while (maxValue < minValue) {// Make sure that maxValue>minValue.
            maxValue = printSquare.getInputNumber("Enter max value:");
        }
        printSquare.printSquare(minValue, maxValue);//call method printSquare.
    }
}
