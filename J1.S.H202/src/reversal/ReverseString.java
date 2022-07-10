/*
 * Copyright(C) 2021, FPT university.
 * J1.S.H202
 *  ReverseString
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-09-18      1.0                 HuyTQ            First Implement
 */
package reversal;

import java.util.Scanner;

/**
 * This class includes 2 method to get a string and print it into reverse oder.
 *
 * @author HuyTQ
 */
public class ReverseString {

    /**
     * This method is used to print string in reverse order.
     *
     * @param string is a input string.
     */
    private void printReverse(String string) {
        System.out.print("After reverse: ");
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
        System.out.println("");
    }

    /**
     * Method main is used to run this program.
     * It ask input from user, create object and call method printReverse.
     * @param args
     */
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String inputString = scanner.nextLine();// Get input from the keyboard.
        reverseString.printReverse(inputString);//Call method to have final  result.
    }
}
