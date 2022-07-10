
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Checker {
    
    private static final Logger LOGGER = Logger.getLogger(Checker.class.getName());
    
    boolean checkRangeNumber(String inputNumber, int min, int max) {
        try {
            int x = Integer.parseInt(inputNumber);
            if (x >= min && x <= max) {
                return true;
            } else {
                LOGGER.log(Level.WARNING, "Choice must in [{0}-{1}], enter again !", new Object[]{min, max});
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Choice must in [{0}-{1}], enter again !", new Object[]{min, max});
        }
        return false;
    }

    boolean checkID(int id, ArrayList<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return true;
            }
        }
        return false;
    }

    boolean checkTimeOfPlan(String inputTime) {
        try {
            float time = Float.parseFloat(inputTime);
            if (time >= 8 && time <= 17.5 && time % 0.5 == 0) {
                return true;
            }else{
                LOGGER.warning("Invalid plan, plan within 8.0-17.5 !");
            }
            
        } catch (NumberFormatException e) {
            LOGGER.warning("Invalid plan, plan within 8.0-17.5 !");
        }
        return false;
    }
    LocalDate checkValidDate(String inputDate) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
            Date date = simpleDateFormat.parse(inputDate); // String to date
            String dateFormatted = simpleDateFormat.format(date); // Format to MMM-dd-yyyy
            LocalDate timeReturn = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (inputDate.equalsIgnoreCase(dateFormatted) && timeReturn.compareTo(LocalDate.now()) >= 0) {
                return timeReturn;
            }
            LOGGER.warning("Your input is invalid. Please try again!");
        } catch (ParseException ex) {
            LOGGER.warning("Your input is invalid (It's must be in format MMM/dd/yyyy). Please try again!");
        }
        return null;
    }
}
