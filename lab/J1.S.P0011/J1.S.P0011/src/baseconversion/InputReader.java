/*
 * Copyright(C) 2021, To Quang Huy
 * J1.S.P0011
 * Change base number system (16, 10, 8,2) program. 
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-01       1.0                HuyTQ            First Implement
 */
package baseconversion;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains 5 methods that can be used to ask the user to enter
 * number from the keyboard.
 *
 * @author HuyTQ
 */
public class InputReader {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    /**
     * This method requires the user to enter a value between min and max
     *
     * @param message notification
     * @param min 
     * @param max 
     * @return value is in the range min to max
     */
    int getInputOption(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message); 
                int choice = Integer.parseInt(SCANNER.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                LOGGER.log(Level.WARNING, "Choice must in [{0}-{1}], enter again !", new Object[]{min, max});
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Choice must in [{0}-{1}], enter again !", new Object[]{min, max});
            }
        }
    }

    /**
     * This method requires the user to enter a binary number from the keyboard
     *
     * @return string consisting of binary numbers
     */
    String getInputBinaryNumber() {
        while (true) {
            System.out.print("Input Binary Number: ");
            String binaryNumber = SCANNER.nextLine().trim();
            if (binaryNumber.matches("^[0-1]+$")) {
                return binaryNumber;
            } else {
                LOGGER.warning("Number must enter 0 or 1. Enter again!");
            }
        }
    }

    /**
     * This method requires the user to enter an octal number from the keyboard
     *
     * @return string consisting of octal numbers
     */
    String getInputOctalNumber() {
        while (true) {
            System.out.print("Input Octal Number: ");
            String octalNumber = SCANNER.nextLine().trim();
            if (octalNumber.matches("^[0-7]+$")) {
                return octalNumber;
            } else {
                LOGGER.warning("Number must be entered between 0 and 7. Enter again!");
            }
        }
    }

    /**
     * This method requires the user to enter a decimal number from the keyboard
     *
     * @return string consisting of decimal numbers
     */
    String getInputDecimalNumber() {
        while (true) {
            System.out.print("Input Decimal Number: ");
            String decimalNumber = SCANNER.nextLine().trim();
            if (decimalNumber.matches("^[0-9]+$")) {
                return decimalNumber;
            } else {
                LOGGER.warning("Number must be entered between 0 and 9. Enter again!");
            }
        }
    }

    /**
     * This method requires the user to enter a hexadecimal number from the
     * keyboard
     *
     * @return string consisting of hexadecimal numbers
     */
    String getInputHexadecimalNumber() {
        while (true) {
            System.out.print("Input Hexadecimal Number: ");
            String hexadecimalNumber = SCANNER.nextLine().trim().toUpperCase();
            if (hexadecimalNumber.matches("^[0-9A-F]+$")) {
                return hexadecimalNumber;
            } else {
                LOGGER.warning("Number must be entered between 0 and 9 ,A and F. Enter again!");
            }
        }
    }
}
