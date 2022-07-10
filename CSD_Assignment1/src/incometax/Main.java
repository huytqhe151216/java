
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
 * This class use for run This program.
 * Create object and call method to have result.
 *
 * @author HUYTQ
 */
public class Main {

    /**
     * This main method for run program.
     *
     * @param args command-line arguments.
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //Create new object of validate
        Validate validate = new Validate();
        //Create new object of Scanner
        Scanner scanner = new Scanner(System.in);
        //Create new objec of CalculateTax
        CalculateTax caculate = new CalculateTax();
        //Display menu of program
        while (true) {
            System.out.println("-----------Tax Caculator-----------------");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to end");
            System.out.println("3. Display data");
            System.out.println("4. Save data to file");
            System.out.println("5. Search by code");
            System.out.println("6. Delete by code");
            System.out.println("7. Sort by code");
            System.out.println("8. Input & add to beginning");
            System.out.println("9. Add after postion k");
            System.out.println("10. Delete position k");
            System.out.println("0. Exit");
            System.out.print("Your selection (0 -> 10): ");
            int choice = validate.getValidChoice();
            switch (choice) {
                case 1:
                    caculate.getInputFromFile();
                    System.out.println("Successfully!");
                    break;
                case 2:
                    caculate.addLast();
                    System.out.println("Successfully!");
                    break;
                case 3:
                    caculate.display();
                    System.out.println("Successfully!");
                    break;
                case 4:
                    caculate.writeToFile();
                    System.out.println("Successfully!");
                    break;
                case 5:
                    caculate.searchByCode();
                    System.out.println("Successfully!");
                    break;
                case 6:
                    caculate.deleteByCode();
                    System.out.println("Successfully!");
                    break;
                case 7:
                    caculate.sortByCode();
                    System.out.println("Successfully!");
                    break;
                case 8:
                    caculate.AddFirst();
                    System.out.println("Successfully!");
                    break;
                case 9:
                    caculate.insertPositionNext();
                    System.out.println("Successfully!");
                    break;
                case 10:
                    caculate.deletePosition();
                    System.out.println("Successfully!");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
