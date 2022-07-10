/*
 * Copyright(C) 2005, FPT university
 * J1.S.H211    
 * fromCOunts
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-01      1.0                 HuyTQ            First Implement
 */
package numberconsequence;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains 3 methods named getInputNumber, addInputToArray,
 * fromCounts that can be used to input a new list from the keyboard and create
 * a new ArrayIntList of values given an existing ArrayIntList of counts.
 *
 * @author huyTQ
 */
public class ArrayIntList {

    private int[] elementData;// this is input array
    private int size;//this is size of array

    /**
     * This method requires the user to enter a number from the keyboard.
     *
     * @param message is a notification string.
     * @return a integer number.
     */
    private int getInputNumber(String message) {
        Logger logger = Logger.getLogger(ArrayIntList.class.getName());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                int inputNumber = Integer.parseInt(scanner.nextLine().trim());
                return inputNumber;
            } catch (NumberFormatException e) {
                logger.warning("Wrong format. Please enter again:");
            }
        }
    }

    /**
     * This method requires the user to enter numbers into the array.
     *
     * @return sizeOfNewArray of array in fromCounts.
     */
    private void addInputToArray() {
        while (true) {//Enter size of array
            size = getInputNumber("Enter size of array: ");
            if (size > 0 && size % 2 == 0) {// size must be positive and even.
                break;
            }
        }
        elementData = new int[size];
        int i = 0;
        while (i < size) {
            while (true) {//enter count>0
                int x = getInputNumber("Enter element[" + i + "]: ");
                if (x > 0) {
                    elementData[i] = x;
                    break;
                }
            }
            i++;
            elementData[i] = getInputNumber("Enter element[" + i + "]: ");//enter number.
            i++;
        }
        System.out.println("list: " + Arrays.toString(elementData));
    }

    /**
     * This method will returns a new ArrayIntList of values given an existing
     * arrayIntList of counts.
     *
     * @return integer array
     */
    private int[] fromCounts() {
        int sizeOfNewArray = 0;
        for (int i = 0; i < size; i += 2) {
            sizeOfNewArray += elementData[i];
        }
        int[] outputArray = new int[sizeOfNewArray];
        int index = 0;
        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < elementData[i]; j++) {
                outputArray[index] = elementData[i + 1];
                index++;
            }
        }
        return outputArray;
    }

    /**
     * This is a main method have an Object to call ArrayIntList methods and run
     * the program.
     *
     * @param args command-line parameter.
     */
    public static void main(String[] args) {
        ArrayIntList arrayIntList = new ArrayIntList();
        arrayIntList.addInputToArray();
        int[] list2 = arrayIntList.fromCounts(); // store in list 2 the values from fromCount
        System.out.println("list2:" + Arrays.toString(list2));//print list2.
    }
}
