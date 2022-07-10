/*
 * Copyright(C) 2005, FPT university
 * J1.S.P0001
 * Bubble Sort 
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-10-12      1.0                 HuyTQ            First Implement
 */
package bubblesortalgorithm;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains getInputRangeNumber, getSizeOfInputArray,
 * createRandomArray,displayArray, sortByBubbleSort and Main function, allows
 * the user to generate a range of random numbers and sort them using the
 * BubbleSort algorithm.
 *
 * @author HUYTQ
 */
public class BubbleSort {

    /**
     * Declare a final variable LOGGER to use logging for class.
     */
    private static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());

    /**
     * Declare a final variable SCANNER to get input for class.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This method is used to display array before and after sorting.
     *
     * @param array is a input array.
     */
    private void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    /**
     * This method require user to enter positive integer number from keyboard
     * as the number of elements of array.
     *
     * @return a positive integer number.
     */
    private int getSizeOfInputArray() {
        while (true) {
            try {
                System.out.print("Enter the number of elements of the array: ");
                int numberElementOfArray = Integer.parseInt(SCANNER.nextLine());
                if (numberElementOfArray > 0) {//The number of elements of the array must be a positive integer.
                    return numberElementOfArray;
                }
            } catch (NumberFormatException e) {// If numberElementOfArray is not a integer  number.
                LOGGER.warning("Please enter a positive number.");
            }
        }
    }

    /**
     * This method is used to check the validity of the input range.
     *
     * @param message for input.
     * @return range is valid with the condition.
     */
    private int getInputRangeNumber(String message) {
        while (true) {
            try {
                System.out.print(message);
                int inputNumber = Integer.parseInt(SCANNER.nextLine());
                return inputNumber;
            } catch (NumberFormatException e) {
                LOGGER.warning("Wrong input format. Please try again.");
            }
        }

    }

    /**
     * This method generates an array of random integers in a given range.
     *
     * @return array is created by random.
     */
    private int[] createRandomArray() {
        int sizeArray = getSizeOfInputArray();
        int rangeMax = 0;
        int rangeMin = getInputRangeNumber("Enter min number: ");
        while (true) {
            rangeMax = getInputRangeNumber("Enter max number: ");
            if (rangeMax > rangeMin) {
                break;
            } else {
                LOGGER.warning("Please enter max number > min number");
            }
        }
        int[] array = new int[sizeArray];
        Random getRandomNumber = new Random();
        for (int i = 0; i < sizeArray; i++) {
            //Add random number into array
            array[i] = getRandomNumber.nextInt(rangeMax - rangeMin + 1) + rangeMin;
        }
        return array;
    }

    /**
     * This method used to sort an array in ascending order by BubbleSort
     * algorithm.
     *
     * @param array is an array to sort
     */
    private void sortByBubbleSort(int[] array) {
        //Compare 2 adjacent numbers in an array one by one.
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // If an element is greater than element after it. Swap 2 element    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * This main method is used to run this program.Create object and call
     * method createRandomArray and sortByBubbleSort.
     *
     * @param args
     */
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();//Create object to call methods.
        int[] array = bubbleSort.createRandomArray();//Intinilize a array by calling createRandomArray().
        System.out.print("Unsorted array: ");
        bubbleSort.displayArray(array);//Display array before sorting.
        bubbleSort.sortByBubbleSort(array);// Sort by bubblesort algorithm.
        System.out.print("Sorted array: ");
        bubbleSort.displayArray(array);//Display array after sorting.
    }
}
