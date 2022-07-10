/*
 * Copyright(C) 2021, To Quang Huy
 * J1.L.P0023
 * Fruit Shop
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-01       1.0                HuyTQ            First Implement
 */
package fruitshop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains 6 methods: getInputString, getInputYesNo
 getInputNumberInRange, getInputInteger, getInputFloat, getInputIdFruit that can be
 used to ask the user for input from the keyboard and return the entered data.
 *
 * @author HuyTQ
 */
public class InputReader {

    private final static Scanner SCANNER = new Scanner(System.in);

    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    private final Checker checker = new Checker();//use checker in this class.

    /**
     * This method requires the user to enter a string into the keyboard (with a
     * specified length) and returns a string
     *
     * @param message notification.
     * @param length fixed length.
     * @return string
     */
    String getInputString(String message, int length) {
        while (true) {
            System.out.print(message);
            String inputString = SCANNER.nextLine().trim();
            if (checker.checkValidString(inputString, length)) {
                return inputString;
            }
            LOGGER.warning("Your input is invalid. Please try again!");
        }
    }

    /**
     * This method requires the user to enter from keyboard and returns an
     * integer value between min and max.
     *
     * @param message notification.
     * @param min 
     * @param max 
     * @param errorMessage when error happens
     * @return a integer between min and max.
     */
    int getInputNumberInRange(String message, int min, int max, String errorMessage) {
        while (true) {
            System.out.print(message); 
            String inputNumber = SCANNER.nextLine().trim();
            if (checker.checkValidRangeNumber(inputNumber, min, max, errorMessage)) {
                return Integer.parseInt(inputNumber);
            }
        }
    }

    /**
     * This method ask user for input an integer until it is greater than minValue.
     *
     * @param message notification
     * @param minValue 
     * @return a integer number > minValue.
     */
    int getInputInteger(String message, int minValue) {
        while (true) {
            System.out.print(message);
            String inputNumber = SCANNER.nextLine().trim();
            if (checker.checkValidIntegerNumber(inputNumber, minValue)) {
                return Integer.parseInt(inputNumber);
            }
        }
    }

    /**
     * This method ask user for input a float until it is a real number and
     * greater than minValue.
     *
     * @param message notification
     * @param minValue of this Value can be.
     * @return a float > minValue
     */
    float getInputFloat(String message, int minValue) {
        while (true) {
            System.out.print(message);
            String inputNumber = SCANNER.nextLine().trim();
            if (checker.checkValidFloatNumber(inputNumber, minValue)) {
                return Float.parseFloat(inputNumber);
            }
        }
    }

    /**
     * This method get user input from keyboard until it's an id of fruit that
     * exist in list.
     *
     * @param fruitsList - array list contain all fruits
     * @return an integer represent for id of fruit that exist in list.
     */
    int getInputIdFruit(ArrayList<Fruit> fruitsList) {
        while (true) {
            int inputId = getInputInteger("Enter fruit ID: ", 0);
            if (checker.checkFruitId(fruitsList, inputId)) {
                return inputId;
            }
            LOGGER.log(Level.WARNING, "ID {0} does not exist", inputId);
        }
    }

    /**
     * This method requires the user to enter Y or N from the keyboard and
     * returns true false
     *
     * @param message notice to enter
     * @return true if it is Y and not otherwise
     */
    boolean getInputYesNo(String message) {
        while (true) {
            System.out.print(message); 
            String inputString = SCANNER.nextLine().trim();
            if (inputString.equalsIgnoreCase("Y")) {
                return true;
            }
            if (inputString.equalsIgnoreCase("N")) {
                return false;
            }
            LOGGER.warning("Must be Y or N. Enter again!");
        }
    }
}
