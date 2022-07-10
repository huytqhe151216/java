/*
 * Copyright(C) 2021, To Quang Huy
 * J1.S.P0071
 * Task Manager
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-06        1.0               HuyTQ            First Implement
 */
package manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains 7 methods that can be used to ask the user for input from
 * the keyboard and return the entered data.
 *
 * @author HuyTQ
 */
public class InputReader {

    /**
     * declare a variable SCANNER 
     */
    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * declare a final variable LOGGER 
     */
    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    private final Checker checker = new Checker(); 

    /**
     * This method requires the user to enter from keyboard and returns an
     * integer value between min and max from the
     *
     * @param message notification
     * @param min 
     * @param max 
     * @return integer value
     */
    int getInputNumberInRange(String message, int min, int max) {
        while (true) {
            System.out.print(message); 
            String inputNumber = SCANNER.nextLine().trim();
            if (checker.checkRangeNumber(inputNumber, min, max)) {
                return Integer.parseInt(inputNumber);
            }
        }
    }

    /**
     * This method requires the user to enter a string into the keyboard  and returns a string that less than given length.
     *
     * @param message notification
     * @param length fixed length
     * @return string
     */
    String getInputString(String message, int length) {
        while (true) {
            System.out.print(message); 
            String inputString = SCANNER.nextLine().trim();
            if (!inputString.isEmpty() && inputString.length() <= length) {
                return inputString;
            }
            LOGGER.log(Level.WARNING, "Input length cannot be empty or must be less than {0} enter again!", length);
        }
    }

    /**
     * This method ask user for input a integer and check if it is in the list
     *
     * @param message notify user input
     * @return a positive integer.
     */
    int getInputId(String message, ArrayList<Task> taskList) {
        while (true) {
            try {
                System.out.print(message);
                int taskId = Integer.parseInt(SCANNER.nextLine().trim());
                if (checker.checkId(taskId, taskList)) {
                    return taskId;
                }
                System.err.println("ID not exist");
            } catch (NumberFormatException ex) {
                System.err.println("Your input doesn't exist. Please try again!");
            }
        }
    }

    /**
     * This method get user input a Date until it is a valid date in format
     * "month-date-year".
     *
     * @param message notification
     * @return valid date
     */
    LocalDate getInputDate(String message, int length) {
        while (true) {
            LocalDate inputDate = checker.checkDate(getInputString(message, length));
            if (inputDate != null) {
                return inputDate;
            }
        }
    }

    /**
     * This method requires the user to enter a time plan from between 8.0 -
     * 17.5 (8h -> 17h30) and returns a string
     *
     * @param message notification
     * @param update if true:use to update. Else doesn't update.
     * @return plan number in range 8.0 -> 17.5
     */
    String getInputPlanFrom(String message, boolean update) {
        while (true) {
            System.out.print(message); 
            String inputPlanFrom = SCANNER.nextLine().trim();
            if (update && inputPlanFrom.equalsIgnoreCase("nope")) {
                return "-1"; //-1 means do not update when user enter "nope"
            }
            if (checker.checkTime(inputPlanFrom) && (Float.parseFloat(inputPlanFrom) != 17.5f)) {
                return inputPlanFrom;
            }
        }
    }

    /**
     * This method requires the user to enter a time plan to from between 8.0 -
     * 17.5 and returns a string
     *
     * @param message notification
     * @param update if true:use to update. Else doesn't update.
     * @return plan number in range 8.0 -> 17.5
     */
    String getInputPlanTo(String message, boolean update) {
        while (true) {
            System.out.print(message); // notify user input
            String inputPlanTo = SCANNER.nextLine().trim();
            if (update && inputPlanTo.equalsIgnoreCase("nope")) {
                return "-1";  //-1 means do not update when user enter "nope"
            }
            if (checker.checkTime(inputPlanTo) && (Float.parseFloat(inputPlanTo) != 8.0f)) {
                return inputPlanTo;
            }
        }
    }

    /**
     * This method requires the user to enter Y or N from the keyboard and
     * returns true false
     *
     * @param message notification
     * @return true if it is Y and not otherwise
     */
    public boolean getInputYN(String message) {
        while (true) {
            System.out.print(message); 
            String inputString = SCANNER.nextLine().trim();
            if (inputString.equalsIgnoreCase("Y")) {
                return true;
            }
            if (inputString.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Must be Y or N. Enter again!");
        }
    }
}
