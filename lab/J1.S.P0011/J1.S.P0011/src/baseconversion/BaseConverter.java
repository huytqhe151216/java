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

import java.math.BigInteger;

/**
 * This class contains 5 methods used to display and convert numbers to decimal
 * and from decimal to other number systems
 *
 * @author HuyTQ
 */
public class BaseConverter {

    private final InputReader inputReader = new InputReader(); // Call InputReader class 

    /**
     * This method will display the user's options as menu and ask the user to
     * enter the selection.
     *
     * @param message notify user input
     * @return choice between 1 - 4
     */
    private int displayMenu(String message) {
        System.out.println(message);
        System.out.println("1. Binary");
        System.out.println("2. Octal");
        System.out.println("3. Decimal");
        System.out.println("4. Hexadecimal");
        return inputReader.getInputOption("Choose: ", 1, 4);
    }

    /**
     * This method will convert numbers in base 2,8,16 to base 10.
     *
     * @param inputNumber
     * @param base
     * @return number in decimal
     */
    private BigInteger convertToDecimal(String inputNumber, int base) {
        int length = inputNumber.length();
        BigInteger decimalNumber = new BigInteger("0");
        int indexOfValue = 0; // index of the last digit
        if (base != 10) {
            while (length != 0) {
                char character = inputNumber.charAt(length - 1);
                int value = (character) <= '9' ? (character - '0') : ((character - 'A') + 10);
                // if the rightmost character is less than or equal to 9 then subtract 48 to get the corresponding int number. If greater than 10, subtract 55
                decimalNumber = decimalNumber.add(BigInteger.valueOf(value).multiply((BigInteger.valueOf(base)).pow(indexOfValue++)));
                length -= 1;
            }
        } else {
            decimalNumber = new BigInteger(inputNumber); // if the value is in base 10 then assign inputNumber to decimalNumber
        }
        return decimalNumber;
    }

    /**
     * This method requires the user to choose a base system for entering
     * numbers and convert it to base 10.
     *
     * @return BigInteger decimal number
     */
    private BigInteger getInputNumberToDecimal() {
        int inputChoice = displayMenu("===== Enter base input number =====");
        switch (inputChoice) {
            case 1:
                return convertToDecimal(inputReader.getInputBinaryNumber(), 2);
            case 2:
                return convertToDecimal(inputReader.getInputOctalNumber(), 8);
            case 3:
                return convertToDecimal(inputReader.getInputDecimalNumber(), 10);
            case 4:
                return convertToDecimal(inputReader.getInputHexadecimalNumber(), 16);
        }
        return null;
    }

    /**
     * This method will convert base 10 to base 2,8,16.
     *
     * @param decimalNumber
     * @param base :the base we want
     * @return string as number after converted
     */
    private String convertDecimalToBase(BigInteger decimalNumber, int base) {
        StringBuilder result = new StringBuilder();
        if (base != 10) {
            while (decimalNumber.compareTo(BigInteger.valueOf(0)) == 1) {
                if ((decimalNumber.mod(BigInteger.valueOf(base))).compareTo(BigInteger.valueOf(10)) < 0) {
                    result.append(decimalNumber.mod(BigInteger.valueOf(base)));
                } else {
                    BigInteger tempValue = decimalNumber.mod(BigInteger.valueOf(base)).add(BigInteger.valueOf(55));
                    result.append((char) (tempValue.intValue()));
                }
                decimalNumber = decimalNumber.divide(BigInteger.valueOf(base));
            }
        }
        result.reverse(); // after all is done we reverse the list
        return result.toString();
    }

    /**
     * This method will print the number after converting from base 10 to base
     * 2,8,16.
     */
    private void printNumberAfterConvert(BigInteger decimalNumber) {
        int inputChoice = displayMenu("====== Enter base output number ======");
        System.out.print("Number after convert: ");
        switch (inputChoice) {
            case 1:
                System.out.print(convertDecimalToBase(decimalNumber, 2));
                break;
            case 2:
                System.out.print(convertDecimalToBase(decimalNumber, 8));
                break;
            case 3:
                System.out.print(decimalNumber);
                break;
            case 4:
                System.out.print(convertDecimalToBase(decimalNumber, 16));
                break;
        }
        System.out.println("");
    }

    /**
     * This is a main method create Object to call methods and run the program.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        BaseConverter baseConverter = new BaseConverter(); // create object
        BigInteger decimalNumber = baseConverter.getInputNumberToDecimal(); // convert to base 10
        baseConverter.printNumberAfterConvert(decimalNumber); // converting from base 10 to other bases
    }

}
