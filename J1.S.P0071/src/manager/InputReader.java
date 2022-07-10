
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class InputReader {

    private final static Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());
    private final Checker checker = new Checker();

    int getInputNumberInRange(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String inputNumber = SCANNER.nextLine().trim();
            if (checker.checkRangeNumber(inputNumber, min, max)) {
                return Integer.parseInt(inputNumber);
            }
        }
    }

    String getInputString(String message, int length) {
        while (true) {
            System.out.print(message);
            String inputString = SCANNER.nextLine().trim();
            if (inputString.isEmpty() == false && inputString.length() <= length) {
                return inputString;
            }
            LOGGER.log(Level.WARNING, "Input length cannot be empty or must be less than {0} enter again!", length);
        }
    }
    int getInputId(String message ,ArrayList<Task> tasks){
        while (true) {
            try {
                System.out.print(message);
                int taskId = Integer.parseInt(SCANNER.nextLine().trim());
                if (checker.checkID(taskId, tasks)) {
                    return taskId;
                }
                LOGGER.warning("ID is not exist");
            } catch (NumberFormatException e) {
                LOGGER.warning("Please enter a integer in range.");
            }
        }
    }
    LocalDate getInputDate(String message){
        while (true) {
            try {
                System.out.print(message);
                String inputDate = SCANNER.nextLine().trim();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
                Date date= simpleDateFormat.parse(inputDate);
                String dateFormatted =simpleDateFormat.format(date);
                LocalDate timeReturn =date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (inputDate.equalsIgnoreCase(dateFormatted)&& timeReturn.compareTo(LocalDate.now())>=0) {
                    return timeReturn;
                }else{
                    LOGGER.warning("Your input is invalid must (ex: 10-Aug-2021) or must be greater than or equal to the current date!");
                }
            } catch (ParseException e) {
                LOGGER.warning("Your input is invalid must (ex: 10-Aug-2021) or must be greater than or equal to the current date!");
            }
        }
    }
    String getInputPlanFrom(String message, boolean update) {
        while (true) {
            System.out.print(message); // notify user input
            String inputPlan = SCANNER.nextLine().trim();
            if (update && inputPlan.equalsIgnoreCase("nope")) {
                return "-1";  // it's update option and user input nope
            }
            if (checker.checkTimeOfPlan(inputPlan) && (Float.parseFloat(inputPlan) != 17.5f)) {
                return inputPlan;
            }
        }
    }
    String getInputPlanTo(String message, boolean update) {
        while (true) {
            System.out.print(message); // notify user input
            String inputPlan = SCANNER.nextLine().trim();
            if (update && inputPlan.equalsIgnoreCase("nope")) {
                return "-1";  // it's update option and user input nope
            }
            if (checker.checkTimeOfPlan(inputPlan) && (Float.parseFloat(inputPlan) != 8.0f)) {
                return inputPlan;
            }
        }
    }
    public boolean getInputYesNo(String mesage){
        while (true) {
            System.out.print(mesage);
            String inputString =SCANNER.nextLine().trim();
            if (inputString.equalsIgnoreCase("y")) {
                return true;
            }
            if (inputString.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Must be Y or N. Please again.");
        }
    }
    
}
