
/*
 * Copyright(C) 2005, FPT university
 * J1.S.P0020
 * Selection sort algorithm. 
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-10-10      1.0                 HuyTQ            First Implement
 */
package selectionsortalgorithm;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains 5 methods to get an array an sort them by selection sort
 * algorithm.
 *
 * @author HUYTQ
 */
public class SelectionSort {

    /**
     * Declare a final variable LOGGER to use logging for class.
     */
    private static final Logger LOGGER = Logger.getLogger(SelectionSort.class.getName());

    /**
     * Declare a final variable SCANNER to get input for class.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This method require user to enter positive integer number from keyboard
     * as the number of elements of array.
     *
     * @return a positive integer number.
     */
    private static int getNumberElementOfArray() {
        while (true) {
            try {
                System.out.print("Enter the number of elements of the array: ");
                int numberElementOfArray = Integer.parseInt(SCANNER.nextLine());
                if (numberElementOfArray > 0) {
                    return numberElementOfArray;
                }
            } catch (NumberFormatException e) {// If numberElementOfArray is not a integer  number.
                LOGGER.warning("Please enter a positive number.");
            }
        }
    }

    /**
     * This method is used to get input elements of array and check them are
     * valid or not.
     *
     * @return a array of type double.
     */
    private double[] getInputArray() {
        double[] inputArray = new double[getNumberElementOfArray()];
        int i = 0;
        while (i < inputArray.length) {// Using while loop to get inputArray follow index "i".
            try {
                System.out.print("InputArray[" + i + "]: ");
                inputArray[i] = Double.parseDouble(SCANNER.nextLine());
                i++;
            } catch (NumberFormatException e) {// If a element is not double type.
                LOGGER.warning("Wrong input format. Please try again.");
            }
        }
        return inputArray;
    }

    /**
     * This method is used to sort an input array by selection sort algorithm.
     *
     * @param inputArray is a array passed in unsorted.
     */
    private void sortBySelectionAlgorithm(double[] inputArray) {
        for (int i = inputArray.length - 1; i > 0; i--) {
            int minIndex = i;
            for (int j = i - 1; j >= 0; j--) {// Find the minimum element in unsorted array.
                if (inputArray[j] > inputArray[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = inputArray[i];
            inputArray[i] = inputArray[minIndex];
            inputArray[minIndex] = temp;
        }
    }

/**
 * This method is used to display array before and after sorting.
 *
 * @param array is a input array.
 */
private void displayArray(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    /**
     * This main method is used to run this program.Create object and call
     * methods getInputArray, displayArray , sortBySelectionAlgorithm.
     *
     * @param args
     */
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();//Create object to call methods.
        double[] array = selectionSort.getInputArray();//Intinilize a array by calling getInputArray().
        System.out.print("Unsorted array: ");
        selectionSort.displayArray(array);//Display array before sorting.
        selectionSort.sortBySelectionAlgorithm(array);//Sort by selectionSortAlgorithm.
        System.out.print("Sorted array: ");
        selectionSort.displayArray(array);//Display array after sorting.
    }
}
