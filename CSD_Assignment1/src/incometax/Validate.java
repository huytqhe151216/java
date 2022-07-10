
/*
 Assignment 1 - Income Tax
 Class ID       : SE1607
 Student ID     : HE151216
 Student Name   : To Quang Huy
 Due Date       : 30 October 2021
 I declare that this assignment is my own work
 in accordance with FPT Policy.
 */
package incometax;

import java.util.Scanner;

/**
 * This method is used to check if input is valid or not.
 *
 * @author HUYTQ
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    /**
     * This method is used to check choice
     *
     * @return choice is a integer in range (0,10)
     */
    public int getValidChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 0 && choice <= 10) {
                    return choice;
                }
                System.out.print("Please input from (0 - 10): ");
            } catch (NumberFormatException e) {
                System.err.print("Please input again: ");
            }
        }
    }

    /**
     * check double.
     *
     * @return a double number
     */
    public double getValidDoub() {
        while (true) {
            try {
                double income = Double.parseDouble(sc.nextLine().trim());
                if (income >= 0) {
                    return income;
                }
                System.out.print("Please input positive: ");
            } catch (NumberFormatException e) {
                System.out.print("Please input again: ");
            }
        }
    }

    /**
     * check integer.
     *
     * @return a integer number.
     */
    public int getValidInt() {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine().trim());
                if (number >= 0) {
                    return number;
                }
                System.out.print("Please input positive: ");
            } catch (NumberFormatException e) {
                System.out.print("Please input again: ");
            }
        }
    }
}
