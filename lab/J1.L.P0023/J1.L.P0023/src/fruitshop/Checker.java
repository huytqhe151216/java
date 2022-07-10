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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains methods to check if the input is in the correct format.
 *
 * @author HuyTQ
 */
public class Checker {

    private static final Logger LOGGER = Logger.getLogger(Checker.class.getName());

    /**
     * This method valid string that user input is not empty and length is
     * smaller than input length
     *
     * @param inputString -string user enter
     * @param length - fixed length user enter
     * @return true: valid else false.
     */
    boolean checkValidString(String inputString, int length) {
        return !inputString.isEmpty() && inputString.length() <= length;
    }

    /**
     * This method checks whether the number is in the range from min or max
     *
     * @param inputNumber
     * @param min 
     * @param max 
     * @param errorString message errorString for input
     * @return true if number is between min and max
     */
    boolean checkValidRangeNumber(String inputNumber, int min, int max, String errorString) {
        try {
            int number = Integer.parseInt(inputNumber);
            if (number >= min && number <= max) {
                return true;
            }
            LOGGER.warning(errorString);
        } catch (NumberFormatException ex) {
            LOGGER.warning(errorString);
        }
        return false;
    }

    /**
     * This method use to check that user input is real number and greater than minValue.
     *
     * @param inputNumber 
     * @param minValue 
     * @return true:valid else false.
     */
    boolean checkValidFloatNumber(String inputNumber, float minValue) {
        try {
            float number = Float.parseFloat(inputNumber);
            if (number >= minValue) {
                return true;
            }
            LOGGER.log(Level.WARNING, "Your input must be getter than {0}.Please try again!", minValue);
        } catch (NumberFormatException ex) {
            LOGGER.warning("Format err. Please enter again: ");
        }
        return false;
    }

    /**
     * This method use to check that user input is integer number and greater than minValue.
     *
     * @param inputNumber 
     * @param minValue 
     * @return true:valid else false.
     */
    boolean checkValidIntegerNumber(String inputNumber, int minValue) {
        try {
            float number = Integer.parseInt(inputNumber);
            if (number >= minValue) {
                return true;
            }
            LOGGER.log(Level.WARNING, "Your input must be getter than {0}.Please try again!", minValue);
        } catch (NumberFormatException ex) {
            LOGGER.warning("Format err. Please enter again: ");
        }
        return false;
    }

    /**
     * This method use to check that id of fruit exist in list or not.
     *
     * @param fruitsList - array list contain all fruitsList
     * @param id - id need to check
     * @return true if id in fruitList else false.
     */
    boolean checkFruitId(ArrayList<Fruit> fruitsList, int id) {
        return fruitsList.stream().anyMatch((fruit) -> (fruit.getFruitId() == id));
    }
}
